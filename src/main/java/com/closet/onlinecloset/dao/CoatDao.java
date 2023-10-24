package com.closet.onlinecloset.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.closet.onlinecloset.doamin.Coat;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CoatDao extends BaseMapper<Coat> {

    @Select("SELECT c.*, cl.* FROM coat c JOIN clothing cl ON c.clothing_id = cl.id AND and cl.type>-1 WHERE c.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    Coat selectById(Long id);

    @Select("<script>" +
            "SELECT c.*, cl.* FROM coat c JOIN clothing cl ON c.clothing_id = cl.id AND cl.type>-1" +
            "<if test='season != null'> WHERE cl.season = #{season}</if>" +
            "</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    List<Coat> selectCoatWithClothing(Integer season);
}