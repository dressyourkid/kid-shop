package ru.dressyourkid.kidshop.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность описания товара (общая информация)
 */
@Entity
public class ProductMeta {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(length = 2000)
    private String description;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    @OneToMany(mappedBy = "productMeta", cascade = CascadeType.PERSIST)
    private List<ProductImage> productImage;

    @OneToMany(mappedBy = "productMeta", cascade = CascadeType.PERSIST)
    private List<ProductStore> productStores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ProductImage> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<ProductImage> productImage) {
        this.productImage = productImage;
    }

    public List<ProductStore> getProductStores() {
        return productStores;
    }

    public void setProductStores(List<ProductStore> productStores) {
        this.productStores = productStores;
    }
}
