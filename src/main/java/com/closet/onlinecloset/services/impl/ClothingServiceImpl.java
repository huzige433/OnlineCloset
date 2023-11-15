package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.ClothingDao;
import com.closet.onlinecloset.doamin.Clothing;
import com.closet.onlinecloset.doamin.Coat;
import com.closet.onlinecloset.services.IClothingService;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClothingServiceImpl extends ServiceImpl<ClothingDao, Clothing> implements IClothingService {

    @Autowired
    private ClothingDao clothingMapper;

    public List<?> getToSeason(Integer season,Integer userid){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("season",season).eq("userid",userid).ne("isActive",-1);
        List<?> clothing=clothingMapper.selectList(wrapper);
        return clothing;
    }
    public List<?> getToSeason(Integer userid){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("userid",userid).ne("isActive",-1);
        List<?> clothing=clothingMapper.selectList(wrapper);
        return clothing;
    }
    public List<?> getToType(Integer type,Integer userid){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("type",type).eq("userid",userid).ne("isActive",-1);
        List<?> clothing=clothingMapper.selectList(wrapper);
        return clothing;
    }

    public Integer getCountToType(Integer type,Integer userid){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("type",type).eq("userid",userid).ne("isActive",-1);
        Integer count=clothingMapper.selectCount(wrapper);
        return count;
    }
    public Integer getCountToIsActive(Integer isactive,Integer userid){
        QueryWrapper<Clothing> wrapper=new QueryWrapper<>();
        wrapper.eq("isActive",isactive).eq("userid",userid);
        Integer count=clothingMapper.selectCount(wrapper);
        return count;
    }


    public List<Map<String, Object>> getClothingJoinOther(){
        // TODO: 2023/11/8 利用连表导出各类数据合集后续进行导出excel操作和导入excel操作
        MPJLambdaWrapper<Clothing> queryWrapper=new MPJLambdaWrapper<>();
        queryWrapper.selectAll(Clothing.class);
        queryWrapper.selectAll(Coat.class);
        queryWrapper.rightJoin(Coat.class, Coat::getClothingId, Clothing::getId);
        queryWrapper.ne(Clothing::getIsactive,"-1");
        return clothingMapper.selectJoinMaps(queryWrapper);
    }

}
