package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;

/**
 * DTO for single product view
 */
public class DiscountDto {

    private String name;
    private BigDecimal percentage;

    public DiscountDto(String name, BigDecimal percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
