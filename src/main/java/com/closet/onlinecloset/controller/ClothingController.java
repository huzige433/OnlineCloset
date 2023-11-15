package com.closet.onlinecloset.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.closet.onlinecloset.doamin.*;
import com.closet.onlinecloset.services.impl.*;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 服装的控制类,服装类包括全部服装元数据
 */
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


    /**
     * 获取所有服装的基础属性clothing
     * @param season 递季节值
     * @param userid 用户id值
     * @return 列表
     */
    @GetMapping("/imglist/{season}")
    public List<?> Imglist(@PathVariable Integer season,@RequestHeader("userid") Integer userid){
        List<?> closets= clothingServiceImpl.getToSeason(season,userid);
        return closets;
    }

    /**
     *不区分季节获取所有衣服参数
     * @param userid
     * @return
     */
    @GetMapping("/imglist")
    public List<?> Imglist(@RequestHeader("userid") Integer userid){
        List<?> closets= clothingServiceImpl.getToSeason(userid);
        return closets;
    }

    /**
     * 获取状态为丢弃状态的服装
     * @param userid
     * @return
     */
    @GetMapping("/recycle")
    public List<?> Recycle(@RequestHeader("userid") Integer userid){
        QueryWrapper<Clothing> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("isActive",-1).eq("userid",userid);
        List<?> closets= clothingServiceImpl.list(queryWrapper);
        return closets;
    }

    /**
     * 将服装状态isActive设置为丢弃
     * @param id
     * @return
     */
    @GetMapping("/deleted/{id}")
    public Boolean delete(@PathVariable Integer id){
        Clothing clothing=clothingServiceImpl.getById(id);
        clothing.setIsactive(-1);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }

    /**
     * 回收丢弃衣服
     * @param id
     * @return
     */
    @GetMapping("/redeleted/{id}")
    public Boolean redelete(@PathVariable Integer id){
        Clothing clothing=clothingServiceImpl.getById(id);
        clothing.setIsactive(1);
        return clothingServiceImpl.saveOrUpdate(clothing);
    }

    /**
     * 删除已经丢弃的服装,删除基础属性与其父表
     * @param id
     * @return
     * @throws Exception
     */
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

    /**
     * 获取所有服装的数量
     * @param userid
     * @return
     */
    @GetMapping("/count")
    public Map<String, Long> clothingCount(@RequestHeader("userid") Integer userid){
        QueryWrapper<Clothing> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("type","count(1) as count")
                .eq("userid",userid)
                .groupBy("type");
        List<Map<String, Object>> result = clothingServiceImpl.listMaps(queryWrapper);
        Map<String, Long> countMap = new HashMap<>();
        for(Map<String,Object> map : result){
            switch ((Integer)map.get("type")) {
                case 0:
                    countMap.put("coatcount", (Long) map.get("count"));
                    break;
                case 1:
                    countMap.put("pantscount", (Long) map.get("count"));
                    break;
                case 2:
                    countMap.put("underwearcount", (Long) map.get("count"));
                    break;
                case 3:
                    countMap.put("shoecount", (Long) map.get("count"));
                    break;
            }
            }
        Integer recycle=clothingServiceImpl.getCountToIsActive(-1,userid);
        countMap.put("recycle", Long.valueOf(recycle));
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

        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "gif");


        if (file.isEmpty()) return "文件不存在";
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        if (!allowedExtensions.contains(suffixName.replace(".","").toLowerCase())) {
            throw new IllegalArgumentException("不支持的文件类型"); // 抛出异常
        }
        String filePath = System.getProperty("user.dir")+"/"+"images/"; // 上传后的路径,即本地磁盘
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            if(file.getSize()>=1024*512){
                Thumbnails.of(file.getInputStream())
                        .size(1024, 768)
                        .outputQuality(0.4f)
                        .outputFormat("jpeg")
                        .toFile(dest);
            }else {
                file.transferTo(dest);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/upload/" + fileName;//本地目录和生成的文件名拼接，这一段存入数据库
        return filename;
    }

    /**
     * 根据服装种类返回排序列
     * @param type
     * @param userid
     * @return
     */
    @GetMapping("/sort/{type}")
    public ClothingSort getsort(@PathVariable Integer type,@RequestHeader("userid") Integer userid){
        QueryWrapper<ClothingSort> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("type",type);
        return clothingSortService.getOne(queryWrapper);
    }

    /**
     * 保存排序列数据
     * @param clothingSort
     * @return
     */
    @PostMapping("/sort")
    public Boolean savesort(@RequestBody ClothingSort clothingSort){
        return clothingSortService.saveOrUpdate(clothingSort);
    }

    /**
     * 总的消费数据,不包括丢弃的
     * @param userid
     * @return
     */
    @GetMapping("getmoneysum")
    public Map getmoney(@RequestHeader("userid") Integer userid){
        QueryWrapper<Clothing> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("sum(price) as money ").eq("userid",userid);
        queryWrapper.ne("isactive",-1);
        return clothingServiceImpl.getMap(queryWrapper);
    }

    @GetMapping("test")
    public List<Map<String, Object>> test(){
        return clothingServiceImpl.getClothingJoinOther();
    }

}
