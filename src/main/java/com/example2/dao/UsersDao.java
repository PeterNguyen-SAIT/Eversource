package com.example2.dao;

import com.example2.entity.UsersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example2.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 */
@Mapper
public interface UsersDao extends BaseMapper<UsersEntity> {
	
}
