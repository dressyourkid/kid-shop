package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.NotFoundException;
import ru.dressyourkid.kidshop.entity.StoreItem;
import ru.dressyourkid.kidshop.model.ProductInfoDto;
import ru.dressyourkid.kidshop.model.ProductListItem;
import ru.dressyourkid.kidshop.model.ProductSingleView;
import ru.dressyourkid.kidshop.repository.StoreRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class ProductService {


    @Autowired
    private StoreRepository storeRepository;

    public List<ProductListItem> list() {
        List<ProductListItem> items = new ArrayList<>();
        items.add(new ProductListItem("Футболка 1", new BigDecimal(49.99)));
        items.add(new ProductListItem("Футболка 2", new BigDecimal(99.99)));
        return items;
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
