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

/**
 * 下装控制类 type1
 */
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


    /**
     * 下装实体列表
     * @param userid
     * @return
     */
    @GetMapping("/list")
    public List<?> list(@RequestHeader("userid") Integer userid){
        return pantsServiceImpl.selectPantsWithClothing(null,userid);
    }

    /**
     * 添加下装实体
     * @param pants
     * @return
     */
    @PostMapping("/add")
    public Pants add(@RequestBody Pants pants){
        Clothing clothing=pants.getClothing();
        clothing.setIsactive(1);
        clothingServiceImpl.saveOrUpdate(clothing);
        Integer clothingId=clothing.getId();
        pants.setClothingId(clothingId);
        pantsServiceImpl.saveOrUpdate(pants);
        return pants;

    }

    /**
     * 真实删除下装实体 弃用
     * @param id
     * @return
     * @throws Exception
     */
    @Deprecated
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
