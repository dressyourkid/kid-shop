package ru.dressyourkid.kidshop.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dressyourkid.kidshop.ApplicationTest;
import ru.dressyourkid.kidshop.entity.Product;

/**
 * Created by lconnected on 05/07/2018.
 */
public class ProductRepositoryTest extends ApplicationTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void productCreated() {
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("descr test");
        product.setAmount(10);
        repository.saveAndFlush(product);
        Assert.assertTrue("Таблица не пустая", repository.count() > 0);
    }

}