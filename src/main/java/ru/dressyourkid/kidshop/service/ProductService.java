package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.Category;
import ru.dressyourkid.kidshop.entity.ProductImage;
import ru.dressyourkid.kidshop.entity.ProductMeta;
import ru.dressyourkid.kidshop.entity.ProductStore;
import ru.dressyourkid.kidshop.model.ProductCreateDto;
import ru.dressyourkid.kidshop.model.ProductDto;
import ru.dressyourkid.kidshop.repository.ProductMetaRepository;
import ru.dressyourkid.kidshop.repository.ProductStoreRepository;

import java.util.ArrayList;
import java.util.Collections;
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

    public Page<ProductDto> findPage(Pageable pageable) {
        Page<ProductMeta> allProductsPage = productMetaRepository.findAll(pageable);
        Page<ProductDto> productPage = allProductsPage
                .map(entity -> convertToDto(entity));
        return productPage;
    }

    public Page<ProductDto> findPage(Pageable pageable, String searchString) {
        Page<ProductMeta> allProductsPage = productMetaRepository.findBySearchString(searchString, pageable);
        Page<ProductDto> productPage = allProductsPage
                .map(entity -> convertToDto(entity));
        return productPage;
    }

    public Page<ProductDto> findPageByCategory(Long categoryId, Pageable pageable) {
        Page<ProductMeta> productsByCategory = productMetaRepository.findByCategoryId(categoryId, pageable);
        Page<ProductDto> productPage = productsByCategory
                .map(entity -> convertToDto(entity));
        return productPage;
    }

    public ProductDto fetchProduct(Long productId) throws NotFoundException {

        ProductMeta productItem = productMetaRepository
                .findById(productId)
                .orElseThrow(NotFoundException::new);

        ProductDto productDto = convertToDto(productItem);
        return productDto;

    }

    private ProductDto convertToDto(ProductMeta productMeta) {
        ProductDto product = new ProductDto();
        product.setId(productMeta.getId());
        product.setName(productMeta.getName());
        product.setDescription(productMeta.getDescription());

//        List<ProductStore> productStores = productStoreRepository.findByProductMetaId(product.getId()).orElse(Collections.emptyList());
        List<ProductStore> productStores = productMeta.getProductStores();

        Optional<ProductStore> firstProductStore = productStores.stream().findFirst();
        product.setExists(firstProductStore.isPresent());
        product.setPrice(firstProductStore.map(ProductStore::getPrice).orElse(null));
        if (productMeta.getProductImage() != null) {
            product.setImageUrlList(
                    productMeta.getProductImage()
                            .stream()
                            .map(ProductImage::getImageUrl)
                            .collect(Collectors.toList())
            );
            product.setMainImageUrl(product.getImageUrlList().stream().findFirst().orElse(null));
        }
        return product;
    }


    public ProductDto addProduct(ProductCreateDto productDto) {
        // 1. create meta
        ProductMeta productMeta = new ProductMeta();
        productMeta.setName(productDto.getName());
        productMeta.setDescription(productDto.getDescription());

        // 2. add store
        if (productDto.getAmount() != null && productDto.getAmount() > 0) {
            List<ProductStore> stores = new ArrayList<>();
            for (int i = 0; i < productDto.getAmount(); i++) {
                ProductStore productStore = new ProductStore();
                productStore.setPrice(productDto.getPrice());
                productStore.setProductMeta(productMeta);
                stores.add(productStore);
            }
            productMeta.setProductStores(stores);
        }

        // 3. add to category
        productMeta.setCategory(new Category(productDto.getCategoryId()));

        // 4. add images
        if (!CollectionUtils.isEmpty(productDto.getImageUrlList())) {
            List<ProductImage> productImages = productDto.getImageUrlList()
                    .stream()
                    .map((image) -> {
                        ProductImage productImage = new ProductImage();
                        productImage.setImageUrl(image);
                        return productImage;
                    })
                    .collect(Collectors.toList());
            productMeta.setProductImage(productImages);
        }

        // 5. persist
        ProductMeta persistentProductMeta = productMetaRepository.save(productMeta);
        return convertToDto(persistentProductMeta);
    }
}
