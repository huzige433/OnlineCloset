package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import com.closet.onlinecloset.services.impl.PantsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/pants")
public class PantsController {

    private final PantsServiceImpl pantsServiceImpl;
    private final ClothingServiceImpl clothingServiceImpl;


    public PantsController(PantsServiceImpl pantsServiceImpl, ClothingServiceImpl clothingServiceImpl) {
        this.pantsServiceImpl = pantsServiceImpl;
        this.clothingServiceImpl = clothingServiceImpl;
    }


    @GetMapping("/list")
    public List<?> list(@RequestHeader("userid") Integer userid){
        return pantsServiceImpl.selectPantsWithClothing(null,userid);
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody Pants pants){
        Clothing clothing=pants.getClothing();
        clothingServiceImpl.saveOrUpdate(clothing);
        Integer clothingId=clothing.getId();
        pants.setClothingId(clothingId);
        return pantsServiceImpl.saveOrUpdate(pants);

    }

    @GetMapping("/deleted/{id}")
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteCoat(@PathVariable Integer id) throws Exception{
        try {
        Pants pants=pantsServiceImpl.getById(id);
        Clothing clothing=pants.getClothing();
        clothingServiceImpl.removeById(clothing.getId());
        return pantsServiceImpl.removeById(id);
        }catch (Exception ex){
            ex.printStackTrace();
            throw  new Exception(ex);
        }
    }

    @GetMapping("/page/{id}")
    public Pants ViewPants(@PathVariable Integer id){
        return pantsServiceImpl.getById(id);

    }


}
