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


/**
 * 标签控制类
 */
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

    /**
     * 根据服装id获取对应的tag标签列表
     * @param clothingid
     * @return
     */
    @GetMapping("/gettag/{clothingid}")
    public List<Tag> gettag(@PathVariable Integer clothingid){
        return tagService.getListByClothingId(clothingid);
    }

    /**
     * 通过标签获取服装列表
     * @param tagid
     * @return
     */
    @GetMapping("/getclothing/{tagid}")
    public List<Clothing> getclothing(@PathVariable Integer tagid,@RequestHeader("userid") Integer userid){
        return tagService.getclothingListByTagId(tagid,userid);
    }

    /**
     * 根据服装属性对应服装类型的tag标签可选项
     * @param type
     * @return
     */
    @GetMapping("/gettagoptions/{type}")
    public List<?> gettagoptions(@PathVariable Integer type){
        QueryWrapper<Tag> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("clothingtype",type);
        return tagService.list(queryWrapper);
    }

    /**
     * 获取所有标签列
     * @return
     */
    @GetMapping("/gettagoptions")
    public List<?> gettagoptions(){

        return tagService.list();
    }


    /**
     * 保存标签实体
     * @param tag
     * @return
     */
    @PostMapping("/save")
    public Integer save(@RequestBody Tag tag){
        if (tagService.save(tag)){
            return tag.getId();
        }else {
            return -1;
        }
    }

    /**
     * 删除标签实体
     * @param tagid
     * @return
     */
    @GetMapping("/remove/{tagid}")
    public Boolean remove(@PathVariable Integer tagid){
        try {
                tagService.deleteclothingtotag(tagid);
                return tagService.removeById(tagid);
        }catch (Exception ex){
            ex.printStackTrace();
            return tagService.removeById(tagid);
        }

    }

    /**
     * 保存服装和标签的关系表数据
     * @param requestData
     * @return
     */
    @PostMapping("/savetag_clothing")
    public Boolean savetag_clothing(@RequestBody JSONObject requestData){
       Integer clothingid= requestData.getInt("clothingid");
       Integer tagid=requestData.getInt("tagid");
        return tagService.saveclothingtotag(clothingid, tagid);
    }

    /**
     * 删除服装与标签的关系
     * @param requestData
     * @return
     */
    @PostMapping("deletetag_clothing")
    public Boolean deletetag_clothing(@RequestBody JSONObject requestData){
        Integer clothingid= requestData.getInt("clothingid");
        Integer tagid=requestData.getInt("tagid");
        return tagService.deleteclothingtotag(clothingid, tagid);
    }

    /**
     * 更加标签获取对应的服装实体属性
     * @param tagid
     * @param type
     * @param <T>
     * @return
     */
    @GetMapping("getclothingfrontag")
    public <T> List<?> getclothingfromtag(@RequestParam("tagid") Integer tagid,@RequestParam("type") Integer type,@RequestHeader("userid") Integer userid){
        List<Clothing> clothings=tagService.getclothingListByTagId(tagid,userid);
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
