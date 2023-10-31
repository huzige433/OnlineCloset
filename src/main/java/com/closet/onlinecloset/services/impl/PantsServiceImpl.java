package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.CoatDao;
import com.closet.onlinecloset.dao.PantsDao;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.services.ICoatService;
import com.closet.onlinecloset.services.IPantsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PantsServiceImpl extends ServiceImpl<PantsDao, Pants> implements IPantsService {

    @Resource
    PantsDao pantsDao;

    @Override
    public List<Pants> selectPantsWithClothing(Integer season,Integer userid) {
        return pantsDao.selectPantsWithClothing(season,userid);
    }

    public <T>List<Pants> selectPantsWithClothing(QueryWrapper<T> wrapper) {
        return pantsDao.selectPantsWithClothingbyWrapper(wrapper);
    }
}
