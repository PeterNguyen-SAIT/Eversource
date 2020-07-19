package ca.sait.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-07-08 23:13:21
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
	private String image;
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

	/** Getter and setter **/
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
