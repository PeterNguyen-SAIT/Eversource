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
@TableName("products")
public class ProductsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer pid;
	/**
	 * 
	 */
	private String pname;
	/**
	 * chinese name
	 */
	private String cname;
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
	private Double discount;
	/**
	 * 
	 */
	private Integer stock;
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
	private String image;
	/**
	 * 
	 */
	private Date shelf;
	/**
	 * 
	 */
	private String note;


}
