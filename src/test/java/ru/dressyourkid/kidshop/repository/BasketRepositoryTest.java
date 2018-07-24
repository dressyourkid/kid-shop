package ru.dressyourkid.kidshop.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dressyourkid.kidshop.ApplicationTest;
import ru.dressyourkid.kidshop.entity.Basket;
import ru.dressyourkid.kidshop.entity.StoreItem;
import ru.dressyourkid.kidshop.entity.User;

public class BasketRepositoryTest extends ApplicationTest {

    @Autowired
    private BasketRepository repository;

    @Test
    public void basketCreated() {
        Basket basket = new Basket();
        basket.setOwner(new User(200L));
        basket.setStoreItem(new StoreItem(1000L));
        basket.setAmount(012L);
        repository.saveAndFlush(basket);
        Assert.assertTrue("таблица не пустая", repository.count() > 0);
    }
}
