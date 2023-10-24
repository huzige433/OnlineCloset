package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import com.closet.onlinecloset.services.impl.PantsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public List<?> list(){
        List<?> closets= pantsServiceImpl.selectPantsWithClothing(null);
        return closets;
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
    public Boolean deleteCoat(@PathVariable long id){
        Pants pants=pantsServiceImpl.getById(id);
        Clothing clothing=pants.getClothing();
        clothingServiceImpl.removeById(clothing.getId());
        return pantsServiceImpl.removeById(id);
    }

    @GetMapping("/page/{id}")
    public Pants ViewPants(@PathVariable long id){
        return pantsServiceImpl.getById(id);

    }


}
