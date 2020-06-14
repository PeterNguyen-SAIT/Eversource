package com.example2.dao;

import com.example2.entity.OrderDetailsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example2.entity.OrderDetailsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 */
@Mapper
public interface OrderDetailsDao extends BaseMapper<OrderDetailsEntity> {
	
}
