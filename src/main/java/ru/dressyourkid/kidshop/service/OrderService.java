package ru.dressyourkid.kidshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.dressyourkid.kidshop.controller.exception.InvalidOrderDataException;
import ru.dressyourkid.kidshop.model.CreateOrderDto;
import ru.dressyourkid.kidshop.repository.ProductMetaRepository;
import ru.dressyourkid.kidshop.repository.ProductStoreRepository;

/**
 * Created by lconnected on 24/07/2018.
 */
@Service
public class OrderService {

    @Autowired
    private ProductMetaRepository productMetaRepository;

    @Autowired
    private ProductStoreRepository productStoreRepository;

    @Autowired
    private NotificationService emailNotificationService;

    @Value("${notification.email.defaultEmailList}")
    private String defaultEmailAddresses;

    public void createOrder(CreateOrderDto orderData) throws InvalidOrderDataException {
        // 1. validate orderData fields
        if (StringUtils.isEmpty(orderData.getName())) {
            throw new InvalidOrderDataException();
        }
        if (StringUtils.isEmpty(orderData.getPhone())) { // todo and invalid regexp
            throw new InvalidOrderDataException();
        }
        if (!StringUtils.isEmpty(orderData.getEmail()) && !orderData.getEmail().contains("@")) { // todo and invalid regexp
            throw new InvalidOrderDataException();
        }
        if (CollectionUtils.isEmpty(orderData.getShoppingCartProducts())) {
            throw new InvalidOrderDataException();
        }
        long invalidItemsCount = orderData.getShoppingCartProducts()
                .stream()
                .filter((cartItem) -> {
                    boolean isValidCartItem = cartItem.getAmount() <= 0 || StringUtils.isEmpty(cartItem.getProductId());
                    // todo maybe check if exists in DB
                    return isValidCartItem;
                })
                .count();
        // fixme maybe better use array of invalid items instead of count
        if (invalidItemsCount > 0) {
            throw new InvalidOrderDataException();
        }

        // 2. check if products in shopping cart is not out of store
        // 3. create order



        try {
            // 4. notify manager
            emailNotificationService.notify(defaultEmailAddresses, "Заказ №ХХХ", "alibaba poshel nah test 001");
            // 5. notify customer
            emailNotificationService.notify(orderData.getEmail(), "Заказ №ХХХ", "alibaba poshel nah test 001");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
