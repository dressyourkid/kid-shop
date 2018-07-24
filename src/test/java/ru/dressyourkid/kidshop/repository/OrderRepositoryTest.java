package ru.dressyourkid.kidshop.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dressyourkid.kidshop.ApplicationTest;
import ru.dressyourkid.kidshop.entity.Order;
import ru.dressyourkid.kidshop.entity.StoreItem;
import ru.dressyourkid.kidshop.entity.User;

public class OrderRepositoryTest extends ApplicationTest {

    @Autowired
    private OrderRepository repository;

    @Test
    public void orderCreated() {
        Order order = new Order();
        order.setStoreItem(new StoreItem(1001L));
        order.setUser(new User(200L));
        order.setAmount(10);
        repository.saveAndFlush(order);
        Assert.assertTrue("Таблица не пустая", repository.count() > 0);
    }
}
