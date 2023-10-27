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
    public List<?> Imglist(@PathVariable Integer season,@RequestHeader("userid") Integer userid){
        List<?> closets= clothingServiceImpl.getToSeason(season,userid);
        return closets;
    }

    @GetMapping("/imglist")
    public List<?> Imglist(@RequestHeader("userid") Integer userid){
        List<?> closets= clothingServiceImpl.getToSeason(userid);
        return closets;
    }

    @GetMapping("/recycle")
    public List<?> Recycle(@RequestHeader("userid") Integer userid){
        List<?> closets= clothingServiceImpl.getToType(-1,userid);
        return closets;
    }

    @GetMapping("/deleted/{id}")
    public Boolean deleteCoat(@PathVariable Integer id){
        Clothing clothing=clothingServiceImpl.getById(id);
        clothing.setType(-1);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }

    @GetMapping("/count")
    public Map<String, Integer> clothingCount(@RequestHeader("userid") Integer userid){
        Integer coatcount=clothingServiceImpl.getCountToType(0,userid);
        Integer pantscount=clothingServiceImpl.getCountToType(1,userid);
        Integer underwearcount=clothingServiceImpl.getCountToType(2,userid);
        Integer shoecount=clothingServiceImpl.getCountToType(3,userid);
        Integer recycle=clothingServiceImpl.getCountToType(-1,userid);
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("coatcount", coatcount);
        countMap.put("pantscount", pantscount);
        countMap.put("underwearcount", underwearcount);
        countMap.put("shoecount", shoecount);
        countMap.put("recycle", recycle);
        return countMap;
    }

}
