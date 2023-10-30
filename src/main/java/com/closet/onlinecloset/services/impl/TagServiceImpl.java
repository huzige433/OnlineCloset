package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.TagDao;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Tag;
import com.closet.onlinecloset.services.ITagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements ITagService {

    @Resource
    TagDao tagDao;

    public List<Tag> getListByClothingId(Integer clothingid) {
        return tagDao.getListByClothingId(clothingid);
    }
    public List<Clothing> getclothingListByTagId(Integer tagid){
        return tagDao.getclothingListByTagId(tagid);
    }
    public Boolean saveclothingtotag(Integer clothingid,Integer tagid){
        return tagDao.saveclothingtotag(clothingid,tagid);
    }


}
