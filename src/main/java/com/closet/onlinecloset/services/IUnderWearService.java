package com.closet.onlinecloset.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.doamin.UnderWear;

import java.util.List;

public interface IUnderWearService extends IService<UnderWear> {
     List<UnderWear> selectUnderWearWithClothing(Integer season);
}
