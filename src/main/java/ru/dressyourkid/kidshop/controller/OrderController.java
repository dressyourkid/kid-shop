package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.dressyourkid.kidshop.controller.exception.InvalidOrderDataException;
import ru.dressyourkid.kidshop.model.CreateOrderDto;
import ru.dressyourkid.kidshop.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody CreateOrderDto orderData) throws InvalidOrderDataException {
        orderService.createOrder(orderData);
    }

}
