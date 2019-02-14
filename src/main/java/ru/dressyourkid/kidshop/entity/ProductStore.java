package ru.dressyourkid.kidshop.entity;

import ru.dressyourkid.kidshop.model.product.ProductStoreStatus;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Сущность склада
 */
@Entity
public class ProductStore {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ProductMeta productMeta;

    @ManyToOne(targetEntity = Discount.class)
    private Discount discount;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private ProductStoreStatus status;

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

    public ProductStoreStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStoreStatus status) {
        this.status = status;
    }
}
