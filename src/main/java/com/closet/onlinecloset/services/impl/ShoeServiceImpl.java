package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.CoatDao;
import com.closet.onlinecloset.dao.ShoeDao;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Shoe;
import com.closet.onlinecloset.services.ICoatService;
import com.closet.onlinecloset.services.IShoeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoeServiceImpl extends ServiceImpl<ShoeDao, Shoe> implements IShoeService {

    @Resource
    ShoeDao shoeDao;

    @Override
    public List<Shoe> selectShoeWithClothing(Integer season,Integer userid) {
        return shoeDao.selectShoeWithClothing(season,userid);
    }
}
