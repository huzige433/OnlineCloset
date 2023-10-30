package com.closet.onlinecloset.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Tag;
import com.closet.onlinecloset.services.impl.TagServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/tags")
public class TagController {
    private TagServiceImpl tagService;

    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
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


    @PostMapping("/save")
    public Integer save(@RequestBody Tag tag){
        if (tagService.save(tag)){
            return tag.getId();
        }else {
            return -1;
        }
    }

    @GetMapping("/savetag_clothing")
    public Boolean savetag_clothing(@RequestParam Integer clothingid,@RequestParam Integer[] tagids){
        System.out.print(clothingid);
        System.out.print(Arrays.toString(tagids));
//        return tagService.saveclothingtotag(clothingid,tagid);
        return true;
    }


}
