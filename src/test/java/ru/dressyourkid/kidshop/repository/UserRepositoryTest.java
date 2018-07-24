package ru.dressyourkid.kidshop.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.dressyourkid.kidshop.ApplicationTest;
import ru.dressyourkid.kidshop.entity.User;

public class UserRepositoryTest extends ApplicationTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void userCreated() {
        User user = new User();
        user.setEmail("luckykeks@gmail.com");
        user.setFirstName("Justin");
        user.setLastName("Biber");
        user.setSocialNetwork("www.Biber.com");
        repository.saveAndFlush(user);
        Assert.assertTrue("Таблица не пустая", repository.count() > 0);
    }
}
