// src/main/java/service/OrderService.java
package service;

import dao.OrderDao;
import model.Order;

public class OrderService {

    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        // Logique métier possible ici (validation, etc.)
        orderDao.saveOrder(order);
    }
}