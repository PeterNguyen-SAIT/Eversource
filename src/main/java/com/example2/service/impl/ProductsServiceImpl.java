package com.example2.service.impl;

import ca.common.utils.PageUtils;
import ca.common.utils.Query;
import com.example2.dao.ProductsDao;
import com.example2.entity.ProductsEntity;
import com.example2.service.ProductsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("productsService")
public class ProductsServiceImpl extends ServiceImpl<ProductsDao, ProductsEntity> implements ProductsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductsEntity> page = this.page(
                new Query<ProductsEntity>().getPage(params),
                new QueryWrapper<ProductsEntity>()
        );

        return new PageUtils(page);
    }

}