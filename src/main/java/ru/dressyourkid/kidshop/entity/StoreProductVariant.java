package ru.dressyourkid.kidshop.entity;

import javax.persistence.*;

/**
 * Сущность варианта продукта на складе (размер и его кол-во)
 */
@Entity
public class StoreProductVariant {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = StoreItem.class)
    private StoreItem store;

    @ManyToOne
    private Size size;

    @Column
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreItem getStore() {
        return store;
    }

    public void setStore(StoreItem store) {
        this.store = store;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
