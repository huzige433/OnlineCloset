package com.closet.onlinecloset.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.closet.onlinecloset.doamin.Coat;

import java.util.List;

public interface ICoatService extends IService<Coat> {
     List<Coat> selectCoatWithClothing( Integer season);
}
