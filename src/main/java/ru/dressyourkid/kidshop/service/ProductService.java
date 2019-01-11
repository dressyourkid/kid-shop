package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;

import ru.dressyourkid.kidshop.entity.ProductStore;
import ru.dressyourkid.kidshop.model.ProductInfoDto;
import ru.dressyourkid.kidshop.model.ProductListItem;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.repository.ProductMetaRepository;
import ru.dressyourkid.kidshop.repository.ProductStoreRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class ProductService {

    @Autowired
    private ProductMetaRepository productMetaRepository;

    @Autowired
    private ProductStoreRepository productStoreRepository;



//
//
//    public List<ProductListItem> findAll(Pageable pageable) {
//        Page<StoreItem> storeItems = storeRepository.findAll(pageable);
//        List<ProductListItem> productListItems = storeItems.stream().map(entity ->
//                new ProductListItem(entity.getProduct().getName(),entity.getItemPrice()))
//                .collect(Collectors.toList());
//     return productListItems;
//    }
//
    public ProductSingleView fetchProduct(Long productId) throws NotFoundException {

        ProductStore productStoreItem = productStoreRepository
                .findById(productId)
                .orElseThrow(NotFoundException::new);

        ProductSingleView product = new ProductSingleView();
        product.setId(productStoreItem.getId());
        product.setName(productStoreItem.getProductMeta().getName());
        product.setDescription(productStoreItem.getProductMeta().getDescription());
        product.setPrice(productStoreItem.getPrice());
        return product;
    }


}
