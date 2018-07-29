package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;

/**
 * DTO for single product view
 */
public class ProductSingleView {

    private String productName;
    private BigDecimal price;


    public ProductSingleView(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
