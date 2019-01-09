package ru.dressyourkid.kidshop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Сущность склада
 */
@Entity
public class ProductStore {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = ProductMeta.class)
    private ProductMeta productMeta;

    @ManyToOne(targetEntity = Discount.class)
    private Discount discount;

    @Column(precision = 12, scale = 9)
    private BigDecimal price;

    public ProductStore() {
    }

    public ProductStore(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductMeta getProductMeta() {
        return productMeta;
    }

    public void setProductMeta(ProductMeta productMeta) {
        this.productMeta = productMeta;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
