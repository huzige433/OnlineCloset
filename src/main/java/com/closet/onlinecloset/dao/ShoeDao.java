package com.closet.onlinecloset.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.closet.onlinecloset.doamin.Shoe;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
@Mapper
public interface ShoeDao extends BaseMapper<Shoe> {

    @Select("SELECT c.*, cl.* FROM shoe c JOIN clothing cl ON c.clothing_id = cl.id AND cl.type>-1 WHERE c.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    Shoe selectById(Integer id);

    @Select("<script>" +
            "SELECT c.*, cl.* FROM shoe c JOIN clothing cl ON c.clothing_id = cl.id AND cl.type>-1" +
            "<if test='season != null'> WHERE cl.season = #{season}</if>" +
            "</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "clothing", column = "clothing_id", one = @One(select = "com.closet.onlinecloset.dao.ClothingDao.selectById"))
    })
    List<Shoe> selectShoeWithClothing(Integer season);
}
