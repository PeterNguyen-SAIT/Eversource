package ca.sait.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-07-08 23:13:21
 */
@Data
@TableName("orders")
public class OrdersEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * oid: This is the primary key in the table.
     */
    @TableId
    private Integer oid;
    /**
     * Store the address for the image
     */
    private String image;
    /**
     * Username for the order
     */
    private String uname;
    /**
     * Product name
     */
    private String pname;
    /**
     * Quantity of the product in the order
     */
    private Integer quantity;
    /**
     * lb,ea,dozen
     */
    private String unit;
    /**
     * Price of the product
     */
    private Double price;
    /**
     * delivery status(ready,complete,hold...)
     */
    private String status;
    /**
     * date created for the order
     */
    private Date createddate;
    /**
     * date scheduled delivery for the order
     */
    private Date deliverydate;
    /**
     * pickup time range to schedule the time
     */
    private String pickup;
    /**
     * Some more details on the order
     */
    private String note;

    /**
     * Getters and setters
     */
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
