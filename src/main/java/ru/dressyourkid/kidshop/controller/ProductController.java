package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dressyourkid.kidshop.model.ProductListItem;
import ru.dressyourkid.kidshop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public List<ProductListItem> list() { // todo see Pageable
        return productService.list();
    }

}
