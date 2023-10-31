package com.closet.onlinecloset.services;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.closet.onlinecloset.doamin.Coat;

import java.util.List;

public interface ICoatService extends IService<Coat> {
     List<Coat> selectCoatWithClothing( Integer season,Integer userid);
     <T>List<Coat> selectCoatWithClothing(QueryWrapper<T> wrapper);
}
