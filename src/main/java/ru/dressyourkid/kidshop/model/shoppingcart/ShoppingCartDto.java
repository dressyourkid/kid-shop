package ru.dressyourkid.kidshop.model.shoppingcart;

import ru.dressyourkid.kidshop.model.ProductDto;

/**
 * DTO for shopping cart
 */
public class ShoppingCartDto {

    private String productId;
    private Integer amount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
