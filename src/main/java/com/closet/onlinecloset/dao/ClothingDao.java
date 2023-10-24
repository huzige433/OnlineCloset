package com.closet.onlinecloset.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Coat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClothingDao extends BaseMapper<Clothing> {

    @Select("SELECT * FROM clothing WHERE id = #{id}")
    Clothing selectById(Integer id);
}
