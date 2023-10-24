package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.UnderWear;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import com.closet.onlinecloset.services.impl.UnderWearServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/underwear")
public class UnderWearController {

    private final UnderWearServiceImpl underWearServiceImpl;
    private final ClothingServiceImpl clothingServiceImpl;


    public UnderWearController( UnderWearServiceImpl underWearServiceImpl, ClothingServiceImpl clothingServiceImpl) {
        this.underWearServiceImpl = underWearServiceImpl;
        this.clothingServiceImpl = clothingServiceImpl;
    }


    @GetMapping("/list")
    public List<?> list(){
        List<?> closets= underWearServiceImpl.selectUnderWearWithClothing(null);
        return closets;
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody UnderWear underWear){
        Clothing clothing=underWear.getClothing();
        clothingServiceImpl.saveOrUpdate(clothing);
        Integer clothingId=clothing.getId();
        underWear.setClothingId(clothingId);
        return underWearServiceImpl.saveOrUpdate(underWear);

    }

    @GetMapping("/deleted/{id}")
    public Boolean deleteCoat(@PathVariable long id){
        UnderWear underWear=underWearServiceImpl.getById(id);
        Clothing clothing=underWear.getClothing();
        clothingServiceImpl.removeById(clothing.getId());
        return underWearServiceImpl.removeById(id);
    }

    @GetMapping("/page/{id}")
    public UnderWear ViewUnderWear(@PathVariable long id){
        return underWearServiceImpl.getById(id);

    }


}
