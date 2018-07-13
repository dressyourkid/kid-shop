package ru.dressyourkid.kidshop.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dressyourkid.kidshop.ApplicationTest;
import ru.dressyourkid.kidshop.entity.Size;



public class SizeRepositoryTest extends ApplicationTest {

    @Autowired
    private SizeRepository repository;

    public void sizeCreated() {
        Size size = new Size();
        size.setName("Size M");
        size.setWidth(0123L);
        size.setHeight(012L);
        repository.saveAndFlush(size);
        Assert.assertTrue("таблица не пустая", repository.count() > 0);
    }
}
