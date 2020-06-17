package ca.sait.entity;

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
 * @date 2020-06-08 17:39:53
 */
@Data
@TableName("products")
public class ProductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer productId;
	/**
	 * 
	 */
	private String productName;
	/**
	 * 
	 */
	private String unit;
	/**
	 * 
	 */
	private Double price;
	/**
	 * 
	 */
	private Integer discountId;
	/**
	 * 
	 */
	private String category;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String productImageAddress;
	/**
	 * 
	 */
	private Date shelfTime;
	/**
	 * 
	 */
	private String note;

}
