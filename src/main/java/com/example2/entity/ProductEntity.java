package com.example2.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private int product_id;
    private String product_name;
    private String unit;
    private double price;
    private int discount_id;
    private String category;
    private  String description;
    private  String product_image_address;
    private Date shelf_time;
    private String note;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
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

    public String getProduct_image_address() {
        return product_image_address;
    }

    public void setProduct_image_address(String product_image_address) {
        this.product_image_address = product_image_address;
    }

    public Date getShelf_time() {
        return shelf_time;
    }

    public void setShelf_time(Date shelf_time) {
        this.shelf_time = shelf_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", discount_id=" + discount_id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", product_image_address='" + product_image_address + '\'' +
                ", shelf_time=" + shelf_time +
                ", note='" + note + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
