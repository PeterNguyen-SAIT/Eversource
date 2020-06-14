package com.example2.service;

import ca.common.utils.PageUtils;
import com.example2.entity.DiscountsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example2.entity.DiscountsEntity;

import java.util.Map;

/**
 * 
 *
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-08 17:39:53
 */
public interface DiscountsService extends IService<DiscountsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

