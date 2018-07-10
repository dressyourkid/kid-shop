package ru.dressyourkid.kidshop.entity;

import javax.persistence.*;

/**
 * Сущность для хранения товаров в корзине
 */
@Entity
@Table(name= "customer_basket")
public class Basket {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StoreItem storeItem;

    @ManyToOne
    private User owner;

    @Column
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreItem getStoreItem() {
        return storeItem;
    }

    public void setStoreItem(StoreItem storeItem) {
        this.storeItem = storeItem;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
