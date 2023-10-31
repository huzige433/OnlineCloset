package com.closet.onlinecloset.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.closet.onlinecloset.dao.CoatDao;
import com.closet.onlinecloset.doamin.*;
import com.closet.onlinecloset.services.impl.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/tags")
public class TagController {
    final private TagServiceImpl tagService;
    final private CoatServiceImpl coatService;
    final private PantsServiceImpl pantsService;
    final private UnderWearServiceImpl underWearService;
    final private ShoeServiceImpl shoeService;

    public TagController(TagServiceImpl tagService, CoatServiceImpl coatService
            , PantsServiceImpl pantsService
            , UnderWearServiceImpl underWearService
            , ShoeServiceImpl shoeService) {
        this.tagService = tagService;
        this.coatService = coatService;
        this.pantsService = pantsService;
        this.underWearService = underWearService;
        this.shoeService = shoeService;
    }

    @GetMapping("/gettag/{clothingid}")
    public List<Tag> gettag(@PathVariable Integer clothingid){
        return tagService.getListByClothingId(clothingid);
    }

    @GetMapping("/getclothing/{tagid}")
    public List<Clothing> getclothing(@PathVariable Integer tagid){
        return tagService.getclothingListByTagId(tagid);
    }

    @GetMapping("/gettagoptions/{type}")
    public List<?> gettagoptions(@PathVariable Integer type){
        QueryWrapper<Tag> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("clothingtype",type);
        return tagService.list(queryWrapper);
    }

    @GetMapping("/gettagoptions")
    public List<?> gettagoptions(){

        return tagService.list();
    }


    @PostMapping("/save")
    public Integer save(@RequestBody Tag tag){
        if (tagService.save(tag)){
            return tag.getId();
        }else {
            return -1;
        }
    }

    @PostMapping("/savetag_clothing")
    public Boolean savetag_clothing(@RequestBody JSONObject requestData){
       Integer clothingid= requestData.getInt("clothingid");
       Integer tagid=requestData.getInt("tagid");
        return tagService.saveclothingtotag(clothingid, tagid);
    }

    @PostMapping("deletetag_clothing")
    public Boolean deletetag_clothing(@RequestBody JSONObject requestData){
        Integer clothingid= requestData.getInt("clothingid");
        Integer tagid=requestData.getInt("tagid");
        return tagService.deleteclothingtotag(clothingid, tagid);
    }

    @GetMapping("getclothingfrontag")
    public <T> List<?> getclothingfromtag(@RequestParam("tagid") Integer tagid,@RequestParam("type") Integer type){
        List<Clothing> clothings=tagService.getclothingListByTagId(tagid);
        if(clothings.size()==0){return null;}
        QueryWrapper<T> queryWrapper =new QueryWrapper<>();
        clothings.forEach(clothing -> queryWrapper.or().eq("clothing_id",clothing.getId()));
        System.out.print(type);
        switch (type){
            case 0:
                return coatService.selectCoatWithClothing(queryWrapper);
            case 1:
                return pantsService.selectPantsWithClothing(queryWrapper);
            case 2:
                return underWearService.selectUnderWearWithClothing(queryWrapper);
            case 3:
                return shoeService.selectShoeWithClothing(queryWrapper);
            default:
                return null;
        }
    }


}
