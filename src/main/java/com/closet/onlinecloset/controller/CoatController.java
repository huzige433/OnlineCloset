package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import com.closet.onlinecloset.services.impl.CoatServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

/**
 * 上装控制类 type0
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/coat")
public class CoatController {

    private final CoatServiceImpl coatServiceImpl;
    private final ClothingServiceImpl clothingServiceImpl;


    public CoatController(CoatServiceImpl coatServiceImpl, ClothingServiceImpl clothingServiceImpl) {
        this.coatServiceImpl = coatServiceImpl;
        this.clothingServiceImpl = clothingServiceImpl;
    }

    /**
     * 根据用户返回对应的上装列表
     * @param userid
     * @return
     */
    @GetMapping("/list")
    public List<?> list(@RequestHeader("userid") Integer userid){

        return coatServiceImpl.selectCoatWithClothing(null,userid);
    }

    /**
     * 添加上装实体,先添加元实体,再添加coat实体
     * @param coat
     * @return
     * @throws Exception
     */
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    public Coat add(@RequestBody Coat coat) throws Exception{
        try {
            Clothing clothing=coat.getClothing();
            clothing.setIsactive(1);
            clothingServiceImpl.saveOrUpdate(clothing);
            Integer clothingId=clothing.getId();
            coat.setClothingId(clothingId);
            coatServiceImpl.saveOrUpdate(coat);
            return coat;
        }catch (Exception ex){
            ex.printStackTrace();
            throw  new Exception(ex);
        }


    }

    /**
     * 未使用
     * @param coatJson
     * @return
     */
    @Deprecated
    @PostMapping("/formadd")
    public Boolean add(@RequestParam("coat") String coatJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Coat coat = objectMapper.readValue(coatJson, Coat.class);
            Clothing clothing=coat.getClothing();
            clothingServiceImpl.saveOrUpdate(clothing);
            Integer clothingId=clothing.getId();
            coat.setClothingId(clothingId);
            return coatServiceImpl.saveOrUpdate(coat);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 弃用
     * @param id
     * @return
     */
    @Deprecated
    @GetMapping("/deleted/{id}")
    public Boolean deleteCoat(@PathVariable Integer id){
        Coat coat=coatServiceImpl.getById(id);
        Clothing clothing=coat.getClothing();
        clothing.setType(-1);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }


    @GetMapping("/page/{id}")
    public Coat ViewCoat(@PathVariable Integer id){
        return coatServiceImpl.getById(id);

    }


}
