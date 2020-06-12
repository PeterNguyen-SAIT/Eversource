package com.example2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-08 17:39:53
 */
@Data
@TableName("order_details")
public class OrderDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer orderDetailId;
	/**
	 * 
	 */
	private Integer productId;
	/**
	 * 
	 */
	private Integer quantity;
	/**
	 * 
	 */
	private String note;

}
