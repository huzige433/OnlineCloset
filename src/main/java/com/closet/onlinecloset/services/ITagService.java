package com.closet.onlinecloset.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Tag;

import java.util.List;

public interface ITagService extends IService<Tag> {

    List<Tag> getListByClothingId(Integer clothingid);
    List<Clothing> getclothingListByTagId(Integer tagid);
    Boolean saveclothingtotag(Integer clothingid,Integer tagid);
    Boolean deleteclothingtotag(Integer clothingid,Integer tagid);
}
