package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.model.ProductListItem;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public List<ProductListItem> listItems() { // todo see Pageable
        return productService.list();
    }

    @GetMapping("/{id}")
    public ProductSingleView singleItem(@PathVariable("id") Long productId) throws NotFoundException { // todo see Pageable
        return productService.fetchProduct(productId);
    }

}
