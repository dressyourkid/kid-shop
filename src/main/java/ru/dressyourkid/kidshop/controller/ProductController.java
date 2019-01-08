package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.model.ProductListItem;
import ru.dressyourkid.kidshop.model.ProductSingleView;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
//    private ProductService productService;

//    @GetMapping("list")
//    public List<ProductSingleView> listItems(Pageable pageable) { // todo see Pageable
//        return productService.findAll(pageable);
//    }

    @GetMapping("/{id}")
    public ProductSingleView singleItem(@PathVariable(value = "id", required = true) Object xyu) throws NotFoundException { // todo see Pageable
//        return productService.fetchProduct(productId);
        ProductSingleView product = new ProductSingleView();
        product.setId(123L);
        product.setName("name one");
        product.setDescription("Very long text with product description");
        return product;
    }

}
