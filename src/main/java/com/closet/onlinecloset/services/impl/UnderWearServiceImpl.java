package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.PantsDao;
import com.closet.onlinecloset.dao.UnderWearDao;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.doamin.UnderWear;
import com.closet.onlinecloset.services.IPantsService;
import com.closet.onlinecloset.services.IUnderWearService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UnderWearServiceImpl extends ServiceImpl<UnderWearDao, UnderWear> implements IUnderWearService {

    @Resource
    UnderWearDao underWearDao;

    @Override
    public List<UnderWear> selectUnderWearWithClothing(Integer season,Integer userid) {
        return underWearDao.selectUnderWearWithClothing(season,userid);
    }

    @Override
    public <T>List<UnderWear> selectUnderWearWithClothing(QueryWrapper<T> wrapper) {
        return underWearDao.selectUnderWearWithClothingbyWrapper(wrapper);
    }
}
