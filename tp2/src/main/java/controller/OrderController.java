// src/main/java/controller/OrderController.java
package controller;

import model.Order;
import service.OrderService;

public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createOrder(Order order) {
        orderService.createOrder(order);
    }
}