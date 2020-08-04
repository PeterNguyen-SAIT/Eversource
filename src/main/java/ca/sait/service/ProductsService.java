package ca.sait.service;

import ca.sait.entity.ProductsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import ca.sait.common.utils.PageUtils;

import java.util.Map;

/**
 * This class is the interface to handle all service related to Product.
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-07-08 23:13:21
 */
public interface ProductsService extends IService<ProductsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

