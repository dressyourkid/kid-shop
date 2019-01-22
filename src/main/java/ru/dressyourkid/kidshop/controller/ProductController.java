package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.model.ProductDto;
import ru.dressyourkid.kidshop.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDto> listItems(Pageable pageable, @RequestParam(value = "search", required = false) String searchString) { // todo see Pageable
        Page<ProductDto> results;
        if (searchString != null) {
            results = productService.findPage(pageable, searchString);
        } else {
            results = productService.findPage(pageable);
        }
        return results;
    }

    @GetMapping("/{id}")
    public ProductDto singleItem(@PathVariable("id") Long productId) throws NotFoundException { // todo see Pageable
        return productService.fetchProduct(productId);
    }

}
