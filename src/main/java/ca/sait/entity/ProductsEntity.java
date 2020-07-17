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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getShelf() {
		return shelf;
	}

	public void setShelf(Date shelf) {
		this.shelf = shelf;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
