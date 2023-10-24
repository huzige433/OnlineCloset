package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.ClothingDao;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.services.IClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingServiceImpl extends ServiceImpl<ClothingDao, Clothing> implements IClothingService {

    @Autowired
    private ClothingDao clothingMapper;

    public List<?> getToSeason(Integer season){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("season",season);
        List<?> clothing=clothingMapper.selectList(wrapper);
        return clothing;
    }
    public List<?> getToSeason(){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        List<?> clothing=clothingMapper.selectList(wrapper);
        return clothing;
    }
    public List<?> getToType(Integer type){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("type",type);
        List<?> clothing=clothingMapper.selectList(wrapper);
        return clothing;
    }

    public Integer getCountToType(Integer type){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("type",type);
        Integer count=clothingMapper.selectCount(wrapper);
        return count;
    }

}
