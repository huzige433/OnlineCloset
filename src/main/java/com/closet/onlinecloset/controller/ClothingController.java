package com.closet.onlinecloset.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.closet.onlinecloset.doamin.*;
import com.closet.onlinecloset.services.impl.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class ClothingController {

    private final ClothingServiceImpl clothingServiceImpl;
    private final ClothingSortServiceImpl clothingSortService;
    final private CoatServiceImpl coatService;
    final private PantsServiceImpl pantsService;
    final private UnderWearServiceImpl underWearService;
    final private ShoeServiceImpl shoeService;

    public ClothingController(ClothingServiceImpl clothingServiceImpl, ClothingSortServiceImpl clothingSortService, CoatServiceImpl coatService, PantsServiceImpl pantsService, UnderWearServiceImpl underWearService, ShoeServiceImpl shoeService) {
        this.clothingServiceImpl = clothingServiceImpl;
        this.clothingSortService = clothingSortService;
        this.coatService = coatService;
        this.pantsService = pantsService;
        this.underWearService = underWearService;
        this.shoeService = shoeService;
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
        QueryWrapper<Clothing> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("isActive",-1);
        List<?> closets= clothingServiceImpl.list(queryWrapper);
        return closets;
    }

    @GetMapping("/deleted/{id}")
    public Boolean delete(@PathVariable Integer id){
        Clothing clothing=clothingServiceImpl.getById(id);
        clothing.setIsactive(-1);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }
    @GetMapping("/redeleted/{id}")
    public Boolean redelete(@PathVariable Integer id){
        Clothing clothing=clothingServiceImpl.getById(id);
        clothing.setIsactive(1);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/remove/{id}")
    public Boolean remove(@PathVariable Integer id) throws Exception{
        try {
            Clothing clothing=clothingServiceImpl.getById(id);
            Integer type=clothing.getType();
            if(type==0){
                QueryWrapper<Coat> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("clothing_id",id);
                coatService.remove(queryWrapper);
            }else if(type==1){
                QueryWrapper<Pants> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("clothing_id",id);
                pantsService.remove(queryWrapper);
            }else if(type==2){
                QueryWrapper<UnderWear> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("clothing_id",id);
                underWearService.remove(queryWrapper);
            }else if(type==3){
                QueryWrapper<Shoe> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("clothing_id",id);
                shoeService.remove(queryWrapper);
            }
            return clothingServiceImpl.removeById(id);
        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

    @GetMapping("/count")
    public Map<String, Integer> clothingCount(@RequestHeader("userid") Integer userid){
        Integer coatcount=clothingServiceImpl.getCountToType(0,userid);
        Integer pantscount=clothingServiceImpl.getCountToType(1,userid);
        Integer underwearcount=clothingServiceImpl.getCountToType(2,userid);
        Integer shoecount=clothingServiceImpl.getCountToType(3,userid);
        Integer recycle=clothingServiceImpl.getCountToIsActive(-1,userid);
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("coatcount", coatcount);
        countMap.put("pantscount", pantscount);
        countMap.put("underwearcount", underwearcount);
        countMap.put("shoecount", shoecount);
        countMap.put("recycle", recycle);
        return countMap;
    }

    /**
     * 上传图片
     *
     * @return
     */
    @RequestMapping(value = "/uploadImages", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImages(@RequestParam(value = "file") MultipartFile file) {

        if (file.isEmpty()) return "文件不存在";
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = System.getProperty("user.dir")+"/"+"images/"; // 上传后的路径,即本地磁盘
        System.out.print(System.getProperty("user.dir")+"/"+"images/");
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/upload/" + fileName;//本地目录和生成的文件名拼接，这一段存入数据库
        return filename;
    }

    @GetMapping("/sort/{type}")
    public ClothingSort getsort(@PathVariable Integer type,@RequestHeader("userid") Integer userid){
        QueryWrapper<ClothingSort> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("type",type);
        return clothingSortService.getOne(queryWrapper);
    }

    @PostMapping("/sort")
    public Boolean savesort(@RequestBody ClothingSort clothingSort){
        return clothingSortService.saveOrUpdate(clothingSort);
    }


}
