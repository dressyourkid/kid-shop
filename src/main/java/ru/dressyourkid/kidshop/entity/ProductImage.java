package ru.dressyourkid.kidshop.entity;

import javax.persistence.*;

/**
 * Сущность хранения ссылок на картинки для товаров
 */
@Entity
public class ProductImage {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 2000)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ProductMeta productMeta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProductMeta getProductMeta() {
        return productMeta;
    }

    public void setProductMeta(ProductMeta productMeta) {
        this.productMeta = productMeta;
    }
}
