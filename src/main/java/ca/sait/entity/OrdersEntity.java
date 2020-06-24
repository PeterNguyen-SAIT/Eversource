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
@TableName("orders")
public class OrdersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer oid;
	/**
	 * 
	 */
	private String uname;
	/**
	 * 
	 */
	private String pname;
	/**
	 * 
	 */
	private Integer quantity;
	/**
	 * delivery status(ready,complete,hold...)
	 */
	private String status;
	/**
	 * 
	 */
	private String note;

}
