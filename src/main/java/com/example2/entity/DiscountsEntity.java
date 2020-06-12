package com.example2.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 */
@Data
@TableName("discounts")
public class DiscountsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer discountId;
	/**
	 * 
	 */
	private String discountName;
	/**
	 * 
	 */
	private Double discountRate;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private Date expiryDate;

}
