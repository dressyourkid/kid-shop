package ru.dressyourkid.kidshop.service;

import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.model.ProductListItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class ProductService {

    public List<ProductListItem> list() {
        List<ProductListItem> items = new ArrayList<>();
        items.add(new ProductListItem("Футболка 1", new BigDecimal(49.99)));
        items.add(new ProductListItem("Футболка 2", new BigDecimal(99.99)));
        return items;
    }

}
