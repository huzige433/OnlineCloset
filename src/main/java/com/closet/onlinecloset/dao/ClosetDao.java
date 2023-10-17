package com.closet.onlinecloset.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.closet.onlinecloset.doamin.Closet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClosetDao extends BaseMapper<Closet> {
}
