package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.StoreItem;
import ru.dressyourkid.kidshop.model.ProductInfoDto;
import ru.dressyourkid.kidshop.model.ProductListItem;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class ProductService {


    @Autowired
    private StoreRepository storeRepository;

    public List<ProductListItem> findAll(Pageable pageable) {
        Page<StoreItem> storeItems = storeRepository.findAll(pageable);
        List<ProductListItem> productListItems = storeItems.stream().map(entity ->
                new ProductListItem(entity.getProduct().getName(),entity.getItemPrice()))
                .collect(Collectors.toList());
     return productListItems;
    }

    public ProductSingleView fetchProduct(Long productId) throws NotFoundException {
        StoreItem storeItem = storeRepository.findById(productId)
                .orElseThrow(NotFoundException::new);
        ProductSingleView item = new ProductSingleView();
        item.setId(productId);
        item.setProductInfo(new ProductInfoDto(storeItem.getProduct().getName(), storeItem.getProduct().getDescription()));
        return item;
    }


}
