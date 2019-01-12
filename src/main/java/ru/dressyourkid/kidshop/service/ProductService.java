package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.ProductMeta;
import ru.dressyourkid.kidshop.entity.ProductStore;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.repository.ProductMetaRepository;
import ru.dressyourkid.kidshop.repository.ProductStoreRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class ProductService {

    @Autowired
    private ProductMetaRepository productMetaRepository;

    @Autowired
    private ProductStoreRepository productStoreRepository;

    public Page<ProductSingleView> findPage(Pageable pageable) {
        Page<ProductMeta> productStorePage = productMetaRepository.findAll(pageable);
        Page<ProductSingleView> productPage = productStorePage
                .map(entity -> convertToDto(entity));
        return productPage;
    }

    public ProductSingleView fetchProduct(Long productId) throws NotFoundException {

        ProductMeta productItem = productMetaRepository
                .findById(productId)
                .orElseThrow(NotFoundException::new);

        ProductSingleView productSingleView = convertToDto(productItem);
        return productSingleView;

    }

    private ProductSingleView convertToDto(ProductMeta productMeta) {
        ProductSingleView product = new ProductSingleView();
        product.setId(productMeta.getId());
        product.setName(productMeta.getName());
        product.setDescription(productMeta.getDescription());

        List<ProductStore> productStores = productStoreRepository.findByProductMetaId(product.getId()).orElse(Collections.emptyList());

        Optional<ProductStore> firstProductStore = productStores.stream().findFirst();
        product.setExists(firstProductStore.isPresent());
        product.setPrice(firstProductStore.map(ProductStore::getPrice).orElse(null));
        return product;
    }


}
