package com.closet.onlinecloset.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.doamin.Pants;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
@Mapper
public interface PantsDao extends BaseMapper<Pants> {

    @Select("SELECT c.*, cl.* FROM pants c JOIN clothing cl ON c.clothing_id = cl.id AND cl.type>-1 WHERE c.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    Coat selectById(Integer id);

    @Select("<script>" +
            "SELECT c.*, cl.* FROM pants c JOIN clothing cl ON c.clothing_id = cl.id AND cl.type>-1 AND cl.userid=#{userid}" +
            "<if test='season != null'> WHERE cl.season = #{season}</if>" +
            "</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    List<Pants> selectPantsWithClothing(Integer season,Integer userid);

    @Select("SELECT c.*, cl.* FROM pants c JOIN clothing cl ON c.clothing_id = cl.id AND cl.type>-1 ${ew.customSqlSegment}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    <T>List<Pants> selectPantsWithClothingbyWrapper(@Param(Constants.WRAPPER) QueryWrapper<T> wrapper);
}
