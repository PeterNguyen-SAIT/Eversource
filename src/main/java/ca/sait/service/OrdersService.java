package ca.sait.service;

import ca.sait.entity.OrdersEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ca.sait.common.utils.PageUtils;

import java.util.Map;

/**
 * This class is the interface to handle all service related to Order.
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-07-08 23:13:21
 */
public interface OrdersService extends IService<OrdersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

