package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;

/**
 * DTO for product list item
 */
public class ProductListItem {

    private String productName;
    private BigDecimal price;

    public ProductListItem(String productName, BigDecimal price) {
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
