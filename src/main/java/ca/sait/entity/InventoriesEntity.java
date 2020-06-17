package ca.sait.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 
 * @author bin
 * @email bin.zhang@sait.ca
 */
@Data
@TableName("inventories")
public class InventoriesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer inventoryId;
	/**
	 * 
	 */
	private Integer productId;
	/**
	 * 
	 */
	private Integer stock;
	/**
	 * 
	 */
	private String location;
	/**
	 * 
	 */
	private String note;

}
