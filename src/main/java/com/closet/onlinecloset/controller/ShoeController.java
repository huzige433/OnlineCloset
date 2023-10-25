package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Shoe;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import com.closet.onlinecloset.services.impl.CoatServiceImpl;
import com.closet.onlinecloset.services.impl.ShoeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/shoe")
public class ShoeController {

    private final ShoeServiceImpl shoeServiceImpl;
    private final ClothingServiceImpl clothingServiceImpl;


    public ShoeController(ShoeServiceImpl shoeServiceImpl, ClothingServiceImpl clothingServiceImpl) {
        this.shoeServiceImpl = shoeServiceImpl;
        this.clothingServiceImpl = clothingServiceImpl;
    }


    @GetMapping("/list")
    public List<?> list(){
        return shoeServiceImpl.selectShoeWithClothing(null);
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody Shoe shoe){
        Clothing clothing=shoe.getClothing();
        clothingServiceImpl.saveOrUpdate(clothing);
        Integer clothingId=clothing.getId();
        shoe.setClothingId(clothingId);
        return shoeServiceImpl.saveOrUpdate(shoe);

    }


    @GetMapping("/deleted/{id}")
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteCoat(@PathVariable Integer id) throws Exception{
        try {
        Shoe shoe=shoeServiceImpl.getById(id);
        Clothing clothing=shoe.getClothing();
        clothingServiceImpl.removeById(clothing.getId());
        return shoeServiceImpl.removeById(id);
        }catch (Exception ex){
            ex.printStackTrace();
            throw  new Exception(ex);
        }
    }

    @GetMapping("/page/{id}")
    public Shoe ViewCoat(@PathVariable Integer id){
        return shoeServiceImpl.getById(id);

    }


}
