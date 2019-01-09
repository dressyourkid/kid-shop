package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.model.ProductListItem;
import ru.dressyourkid.kidshop.model.ProductSingleView;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

//    @Autowired
//    private ProductService productService;

    @GetMapping
    public Page<ProductSingleView> listItems(Pageable pageable) { // todo see Pageable
        List<ProductSingleView> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ProductSingleView product = new ProductSingleView();
            product.setId((long) i);
            product.setName("name one");
            product.setDescription("Very long text with product description");
            product.setPrice(new BigDecimal(100L));
            results.add(product);
        }
        return new PageImpl<>(results);
    }

    @GetMapping("/{id}")
    public ProductSingleView singleItem(@PathVariable("id") Long productId) throws NotFoundException { // todo see Pageable
//        return productService.fetchProduct(productId);
        ProductSingleView product = new ProductSingleView();
        product.setId(productId);
        product.setName("name one");
        product.setDescription("Very long text with product description");
        product.setPrice(new BigDecimal(100L));
        return product;
    }

}
