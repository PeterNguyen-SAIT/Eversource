package ca.sait.dao;

import ca.sait.entity.OrderDetailsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
