package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.StoreItem;
import ru.dressyourkid.kidshop.model.ProductInfoDto;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.repository.StoreRepository;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class ProductService {


    @Autowired
    private StoreRepository storeRepository;

    public Page<StoreItem> list(Pageable pageable) {
//        items.add(new ProductListItem("Футболка 1", new BigDecimal(49.99)));
//        items.add(new ProductListItem("Футболка 2", new BigDecimal(99.99)));
        return storeRepository.findAll(pageable);
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
