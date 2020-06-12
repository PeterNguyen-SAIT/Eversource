package com.example2.service.impl;

import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;
import ca.sait.dao.OrderDetailsDao;
import ca.sait.entity.OrderDetailsEntity;
import ca.sait.service.OrderDetailsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("orderDetailsService")
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsDao, OrderDetailsEntity> implements OrderDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderDetailsEntity> page = this.page(
                new Query<OrderDetailsEntity>().getPage(params),
                new QueryWrapper<OrderDetailsEntity>()
        );

        return new PageUtils(page);
    }

}