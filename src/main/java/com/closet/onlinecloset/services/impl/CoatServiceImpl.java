package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.ClothingDao;
import com.closet.onlinecloset.dao.CoatDao;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.services.ICoatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Collection;
import java.util.List;

@Service
public class CoatServiceImpl extends ServiceImpl<CoatDao, Coat> implements ICoatService {

    @Resource
    CoatDao coatDao;

    @Override
    public List<Coat> selectCoatWithClothing(Integer season,Integer userid) {
        return coatDao.selectCoatWithClothing(season,userid);
    }

    public <T>List<Coat> selectCoatWithClothing(QueryWrapper<T> wrapper) {
        return coatDao.selectCoatWithClothingbyWrapper(wrapper);
    }
}
