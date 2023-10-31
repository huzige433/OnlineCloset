package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import com.closet.onlinecloset.services.impl.CoatServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/coat")
public class CoatController {

    private final CoatServiceImpl coatServiceImpl;
    private final ClothingServiceImpl clothingServiceImpl;


    public CoatController(CoatServiceImpl coatServiceImpl, ClothingServiceImpl clothingServiceImpl) {
        this.coatServiceImpl = coatServiceImpl;
        this.clothingServiceImpl = clothingServiceImpl;
    }


    @GetMapping("/list")
    public List<?> list(@RequestHeader("userid") Integer userid){

        return coatServiceImpl.selectCoatWithClothing(null,userid);
    }

    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public Coat add(@RequestBody Coat coat) throws Exception{
        try {
            Clothing clothing=coat.getClothing();
            clothingServiceImpl.saveOrUpdate(clothing);
            Integer clothingId=clothing.getId();
            coat.setClothingId(clothingId);
            coatServiceImpl.saveOrUpdate(coat);
            return coat;
        }catch (Exception ex){
            ex.printStackTrace();
            throw  new Exception(ex);
        }


    }

    @PostMapping("/formadd")
    public Boolean add(@RequestParam("coat") String coatJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Coat coat = objectMapper.readValue(coatJson, Coat.class);
            Clothing clothing=coat.getClothing();
            clothingServiceImpl.saveOrUpdate(clothing);
            Integer clothingId=clothing.getId();
            coat.setClothingId(clothingId);
            return coatServiceImpl.saveOrUpdate(coat);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }




    @GetMapping("/deleted/{id}")
    public Boolean deleteCoat(@PathVariable Integer id){
        Coat coat=coatServiceImpl.getById(id);
        Clothing clothing=coat.getClothing();
        clothing.setType(4);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }

    @GetMapping("/page/{id}")
    public Coat ViewCoat(@PathVariable Integer id){
        return coatServiceImpl.getById(id);

    }


}
