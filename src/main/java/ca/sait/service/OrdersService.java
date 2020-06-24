package ca.sait.service;


import ca.sait.common.utils.PageUtils;
import ca.sait.entity.OrdersEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-23 11:04:00
 */
public interface OrdersService extends IService<OrdersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

