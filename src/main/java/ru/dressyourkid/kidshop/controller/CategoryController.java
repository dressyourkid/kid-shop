package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.model.CategoryDto;
import ru.dressyourkid.kidshop.model.ProductDto;
import ru.dressyourkid.kidshop.service.CategoryService;
import ru.dressyourkid.kidshop.service.ProductService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<CategoryDto> listItems(Pageable pageable) { // todo see Pageable
        return categoryService.findPage(pageable);
    }

    @GetMapping("/{id}/product")
    public Page<ProductDto> productsByCategory(@PathVariable("id") Long categoryId, Pageable pageable) throws NotFoundException { // todo see Pageable
        return productService.findPageByCategory(categoryId, pageable);
    }

}
