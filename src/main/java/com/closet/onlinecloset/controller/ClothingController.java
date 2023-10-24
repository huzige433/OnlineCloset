package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import com.closet.onlinecloset.services.impl.PantsServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class ClothingController {

    private final ClothingServiceImpl clothingServiceImpl;


    public ClothingController( ClothingServiceImpl clothingServiceImpl) {
        this.clothingServiceImpl = clothingServiceImpl;
    }


    @GetMapping("/imglist/{season}")
    public List<?> Imglist(@PathVariable Integer season){
        List<?> closets= clothingServiceImpl.getToSeason(season);
        return closets;
    }

    @GetMapping("/imglist")
    public List<?> Imglist(){
        List<?> closets= clothingServiceImpl.getToSeason();
        return closets;
    }

    @GetMapping("/recycle")
    public List<?> Recycle(){
        List<?> closets= clothingServiceImpl.getToType(-1);
        return closets;
    }

    @GetMapping("/deleted/{id}")
    public Boolean deleteCoat(@PathVariable Integer id){
        Clothing clothing=clothingServiceImpl.getById(id);
        clothing.setType(-1);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }

    @GetMapping("/count")
    public Map<String, Integer> clothingCount(){
        Integer coatcount=clothingServiceImpl.getCountToType(0);
        Integer pantscount=clothingServiceImpl.getCountToType(1);
        Integer underwearcount=clothingServiceImpl.getCountToType(2);
        Integer shoecount=clothingServiceImpl.getCountToType(3);
        Integer recycle=clothingServiceImpl.getCountToType(-1);
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("coatcount", coatcount);
        countMap.put("pantscount", pantscount);
        countMap.put("underwearcount", underwearcount);
        countMap.put("shoecount", shoecount);
        countMap.put("recycle", recycle);
        return countMap;
    }

}
