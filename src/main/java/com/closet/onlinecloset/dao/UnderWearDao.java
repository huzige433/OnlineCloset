package com.closet.onlinecloset.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Pants;
import com.closet.onlinecloset.doamin.UnderWear;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
@Mapper
public interface UnderWearDao extends BaseMapper<UnderWear> {

    @Select("SELECT c.*, cl.* FROM underwear c JOIN clothing cl ON c.clothing_id = cl.id AND cl.isactive>-1 WHERE c.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    Coat selectById(Integer id);

    @Select("<script>" +
            "SELECT c.*, cl.* FROM underwear c JOIN clothing cl ON c.clothing_id = cl.id AND cl.isactive>-1 AND cl.userid=#{userid}" +
            "<if test='season != null'> WHERE cl.season = #{season}</if>" +
            "</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    List<UnderWear> selectUnderWearWithClothing(Integer season,Integer userid);

    @Select("SELECT c.*, cl.* FROM underwear c JOIN clothing cl ON c.clothing_id = cl.id AND cl.isactive>-1 ${ew.customSqlSegment}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    <T>List<UnderWear> selectUnderWearWithClothingbyWrapper(@Param(Constants.WRAPPER) QueryWrapper<T> wrapper);
}
