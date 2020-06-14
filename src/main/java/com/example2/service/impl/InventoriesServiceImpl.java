package com.example2.service.impl;

import ca.common.utils.PageUtils;
import ca.common.utils.Query;
import com.example2.dao.InventoriesDao;
import com.example2.entity.InventoriesEntity;
import com.example2.service.InventoriesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("inventoriesService")
public class InventoriesServiceImpl extends ServiceImpl<InventoriesDao, InventoriesEntity> implements InventoriesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InventoriesEntity> page = this.page(
                new Query<InventoriesEntity>().getPage(params),
                new QueryWrapper<InventoriesEntity>()
        );

        return new PageUtils(page);
    }

}