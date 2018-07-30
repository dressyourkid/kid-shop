package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for single product view
 */
public class ProductSingleView {

    private Long id;
    private ProductInfoDto productInfo;
    private List<DiscountDto> discounts;
    private List<SizeDto> sizes;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductInfoDto getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfoDto productInfoDto) {
        this.productInfo = productInfoDto;
    }

    public List<DiscountDto> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountDto> discounts) {
        this.discounts = discounts;
    }

    public List<SizeDto> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeDto> sizes) {
        this.sizes = sizes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
