package ru.dressyourkid.kidshop.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dressyourkid.kidshop.ApplicationTest;
import ru.dressyourkid.kidshop.entity.Discount;
import ru.dressyourkid.kidshop.entity.Product;
import ru.dressyourkid.kidshop.entity.StoreItem;


import java.math.BigDecimal;


public class StoreItemRepositoryTest extends ApplicationTest {

    @Autowired
    private StoreRepository repository;

    @Test
    public void storeItemCreated() {
        StoreItem storeItem = new StoreItem();
        storeItem.setDiscount(new Discount());
        storeItem.setItemPrice(new BigDecimal(2));
        storeItem.setProduct(new Product());
        repository.saveAndFlush(storeItem);
        Assert.assertTrue("Таблица не пустая", repository.count() > 0);
    }
}
