package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.Category;
import ru.dressyourkid.kidshop.entity.ProductMeta;
import ru.dressyourkid.kidshop.entity.ProductStore;
import ru.dressyourkid.kidshop.model.CategoryDto;
import ru.dressyourkid.kidshop.model.ProductDto;
import ru.dressyourkid.kidshop.repository.CategoryRepository;
import ru.dressyourkid.kidshop.repository.ProductMetaRepository;
import ru.dressyourkid.kidshop.repository.ProductStoreRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by lconnected on 12/01/2019.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Page<CategoryDto> findPage(Pageable pageable) {
        Page<Category> allProductsPage = categoryRepository.findAll(pageable);
        Page<CategoryDto> categoryPage = allProductsPage
                .map(entity -> convertToDto(entity));
        return categoryPage;
    }

    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

}
