package ca.sait.service;


import ca.sait.common.utils.PageUtils;
import ca.sait.entity.ProductsEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-23 11:04:00
 */
public interface ProductsService extends IService<ProductsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

