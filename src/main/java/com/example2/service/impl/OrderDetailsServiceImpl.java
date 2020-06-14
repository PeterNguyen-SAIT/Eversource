package com.example2.service.impl;

import ca.common.utils.PageUtils;
import ca.common.utils.Query;
import com.example2.dao.OrderDetailsDao;
import com.example2.entity.OrderDetailsEntity;
import com.example2.service.OrderDetailsService;
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