package com.closet.onlinecloset;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.closet.onlinecloset.dao.CoatDao;
import com.closet.onlinecloset.dao.PantsDao;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
//import com.closet.onlinecloset.services.impl.TagServiceImpl;
import com.closet.onlinecloset.services.impl.TagServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class OnlineClosetApplicationTests {

    @Autowired
    private  ClothingServiceImpl clothingService;

    @Test
    void contextLoads() {
        QueryWrapper<Clothing> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("type","count(1) as count")
                .groupBy("type");
        List<Map<String, Object>> result = clothingService.listMaps(queryWrapper);
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
                case -1:
                    countMap.put("recycle", (Long) map.get("count"));
                    break;
            }
        }
        System.out.print(countMap);


    }

}
