package com.example2.service.impl;

import ca.common.utils.PageUtils;
import ca.common.utils.Query;
import com.example2.dao.EventsDao;
import com.example2.entity.EventsEntity;
import com.example2.service.EventsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("eventsService")
public class EventsServiceImpl extends ServiceImpl<EventsDao, EventsEntity> implements EventsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EventsEntity> page = this.page(
                new Query<EventsEntity>().getPage(params),
                new QueryWrapper<EventsEntity>()
        );

        return new PageUtils(page);
    }

}