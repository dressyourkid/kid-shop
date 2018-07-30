package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;

/**
 * DTO for single product view
 */
public class ProductInfoDto {

    private String productName;
    private String productDescription;

    public ProductInfoDto(String productName, String productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
