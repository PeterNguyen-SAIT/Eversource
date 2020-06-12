package com.example2.dao;

import ca.sait.entity.ProductsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 */
@Mapper
public interface ProductsDao extends BaseMapper<ProductsEntity> {
	
}
