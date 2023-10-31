package com.closet.onlinecloset.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagDao extends BaseMapper<Tag> {

    @Select("select * from tag left join tag_clothing on tag.id=tag_clothing.tagid where tag_clothing.clothingid=#{clothingid}")
    List<Tag> getListByClothingId(Integer clothingid);

    @Select("select * from clothing left join tag_clothing on clothing.id=tag_clothing.clothingid where tag_clothing.tagid=#{tagid}")
    List<Clothing> getclothingListByTagId(Integer tagid);

    @Insert("insert into tag_clothing(clothingid,tagid) values(#{clothingid},#{tagid})")
    Boolean saveclothingtotag(Integer clothingid,Integer tagid);

    @Delete("delete from tag_clothing where clothingid=#{clothingid} and tagid=#{tagid}")
    Boolean deleteclothingtotag(Integer clothingid,Integer tagid);
}
