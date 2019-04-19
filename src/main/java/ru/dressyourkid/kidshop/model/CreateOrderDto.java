package ru.dressyourkid.kidshop.model;

import ru.dressyourkid.kidshop.model.shoppingcart.ShoppingCartDto;

import java.util.List;

/**
 * DTO for order
 */
public class CreateOrderDto {

    private String name;
    private String phone;
    private String email;
    private List<ShoppingCartDto> shoppingCartProducts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ShoppingCartDto> getShoppingCartProducts() {
        return shoppingCartProducts;
    }

    public void setShoppingCartProducts(List<ShoppingCartDto> shoppingCartProducts) {
        this.shoppingCartProducts = shoppingCartProducts;
    }
}
