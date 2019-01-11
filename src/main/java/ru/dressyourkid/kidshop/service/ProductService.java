package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.ProductStore;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.repository.ProductStoreRepository;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class ProductService {

    @Autowired
    private ProductStoreRepository productStoreRepository;

    public Page<ProductSingleView> findPage(Pageable pageable) {
        Page<ProductStore> productStorePage = productStoreRepository.findAll(pageable);
        Page<ProductSingleView> productPage = productStorePage
                .map(entity -> {
                    ProductSingleView product = new ProductSingleView();
                    product.setId(entity.getId());
                    product.setName(entity.getProductMeta().getName());
                    product.setDescription(entity.getProductMeta().getDescription());
                    product.setPrice(entity.getPrice());
                    return product;
                });
        return productPage;
    }

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
