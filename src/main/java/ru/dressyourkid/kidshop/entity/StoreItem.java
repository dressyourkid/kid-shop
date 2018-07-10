package ru.dressyourkid.kidshop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Сущность склада
 */
@Entity
@Table(name = "store")
public class StoreItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @OneToMany(targetEntity = StoreProductVariant.class)
    private List<StoreProductVariant> variants;

    @ManyToOne(targetEntity = Discount.class)
    private Discount discount;

    @Column
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<StoreProductVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<StoreProductVariant> variants) {
        this.variants = variants;
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
