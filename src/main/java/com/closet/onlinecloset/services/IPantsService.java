package com.closet.onlinecloset.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Pants;

import java.util.List;

public interface IPantsService extends IService<Pants> {
     List<Pants> selectPantsWithClothing( Integer season,Integer userid);
     <T>List<Pants> selectPantsWithClothing(QueryWrapper<T> wrapper);
}
