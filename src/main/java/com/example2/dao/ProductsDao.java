package com.example2.dao;

import com.example2.entity.ProductsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example2.entity.ProductsEntity;
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
