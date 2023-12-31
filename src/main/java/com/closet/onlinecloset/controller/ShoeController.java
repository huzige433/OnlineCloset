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

/**
 * 鞋子类 type3
 */
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
    public List<?> list(@RequestHeader("userid") Integer userid){
        return shoeServiceImpl.selectShoeWithClothing(null,userid);
    }

    @PostMapping("/add")
    public Shoe add(@RequestBody Shoe shoe){
        Clothing clothing=shoe.getClothing();
        clothing.setIsactive(1);
        clothingServiceImpl.saveOrUpdate(clothing);
        Integer clothingId=clothing.getId();
        shoe.setClothingId(clothingId);
        shoeServiceImpl.saveOrUpdate(shoe);
        return shoe;

    }

    /**
     * 弃用
     * @param id
     * @return
     * @throws Exception
     */
    @Deprecated
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
