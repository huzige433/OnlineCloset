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
        clothingService.getClothingJoinOther();


    }

}
