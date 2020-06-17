package ca.sait.dao;

import ca.sait.entity.EventsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 */
@Mapper
public interface EventsDao extends BaseMapper<EventsEntity> {
	
}
