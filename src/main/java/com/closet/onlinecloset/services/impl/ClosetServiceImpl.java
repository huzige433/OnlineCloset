package com.closet.onlinecloset.services.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.closet.onlinecloset.dao.ClosetDao;
import com.closet.onlinecloset.doamin.Closet;
import com.closet.onlinecloset.services.IClosetService;
import org.springframework.stereotype.Service;

@Service
public class ClosetServiceImpl extends ServiceImpl<ClosetDao, Closet> implements IClosetService {


}
