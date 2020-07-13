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
	 * lb,ea,dozen
	 */
	private String unit;
	/**
	 * 
	 */
	private Double price;
	/**
	 * delivery status(ready,complete,hold...)
	 */
	private String status;
	/**
	 * date created
	 */
	private Date createddate;
	/**
	 * date delivery
	 */
	private Date deliverydate;
	/**
	 * pickup time range
	 */
	private String pickup;
	/**
	 * 
	 */
	private String note;

}
