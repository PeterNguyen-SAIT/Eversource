package ca.sait.service.impl;


import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;
import ca.sait.dao.OrdersDao;
import ca.sait.entity.OrdersEntity;
import ca.sait.service.OrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrdersEntity> page = this.page(
                new Query<OrdersEntity>().getPage(params),
                new QueryWrapper<OrdersEntity>()
        );

        return new PageUtils(page);
    }

}