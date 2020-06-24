package ca.sait.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-23 11:04:00
 */
@Data
@TableName("events")
public class EventsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * event_id
	 */
	@TableId
	private Integer eid;
	/**
	 * 
	 */
	private String event;
	/**
	 * 
	 */
	private String description;
	/**
	 * start_date
	 */
	private Date start;
	/**
	 * end_date
	 */
	private Date end;
	/**
	 * 
	 */
	private String status;

}
