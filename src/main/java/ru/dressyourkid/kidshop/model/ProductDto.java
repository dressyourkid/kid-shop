package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for single product view
 */
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean exists;
    private List<String> imageUrlList;
    private String mainImageUrl;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }
}
