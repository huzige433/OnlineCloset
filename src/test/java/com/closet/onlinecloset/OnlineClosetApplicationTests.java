package com.closet.onlinecloset;

import com.closet.onlinecloset.dao.CoatDao;
import com.closet.onlinecloset.dao.PantsDao;
import com.closet.onlinecloset.services.impl.ClothingServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineClosetApplicationTests {

    @Autowired
    private ClothingServiceImpl clothingService;

    @Test
    void contextLoads() {
        System.out.print(clothingService.getCountToType(0));


    }

}
