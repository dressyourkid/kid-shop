package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.StoreItem;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public Page<StoreItem> listItems(Pageable pageable) { // todo see Pageable
        return productService.list(pageable);
    }

    @GetMapping("/{id}")
    public ProductSingleView singleItem(@PathVariable("id") Long productId) throws NotFoundException { // todo see Pageable
        return productService.fetchProduct(productId);
    }

}
