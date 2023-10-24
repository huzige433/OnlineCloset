package com.closet.onlinecloset.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Shoe;

import java.util.List;

public interface IShoeService extends IService<Shoe> {
     List<Shoe> selectShoeWithClothing(Integer season);
}
