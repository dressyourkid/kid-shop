package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;

/**
 * Created by lconnected on 24/07/2018.
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
