package com.closet.onlinecloset.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.doamin.UnderWear;

import java.util.List;

public interface IUnderWearService extends IService<UnderWear> {
     List<UnderWear> selectUnderWearWithClothing(Integer season,Integer userid);
     <T>List<UnderWear> selectUnderWearWithClothing(QueryWrapper<T> wrapper);
}
