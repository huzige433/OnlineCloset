package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.ClothingDao;
import com.closet.onlinecloset.dao.ClothingSortDao;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.ClothingSort;
import com.closet.onlinecloset.services.IClothingService;
import com.closet.onlinecloset.services.IClothingSortService;
import org.springframework.stereotype.Service;

@Service
public class ClothingSortServiceImpl extends ServiceImpl<ClothingSortDao, ClothingSort> implements IClothingSortService {
}
