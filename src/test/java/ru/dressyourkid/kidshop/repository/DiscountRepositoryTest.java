package ru.dressyourkid.kidshop.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dressyourkid.kidshop.ApplicationTest;
import ru.dressyourkid.kidshop.entity.Discount;

import java.math.BigDecimal;

public class DiscountRepositoryTest extends ApplicationTest {

    @Autowired
    private DiscountRepository repository;

    @Test
    public void discountCreated() {
        Discount discount = new Discount();
        discount.setName("Skidka");
        discount.setPercentage(new BigDecimal(2));
        repository.saveAndFlush(discount);
        Assert.assertTrue("Таблица не пустая", repository.count() > 0);
    }
}
