// src/test/java/controller/OrderControllerTest.java
package controller;

import dao.OrderDao;
import model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.OrderService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderDao orderDao;          // Mock de la couche DAO

    @Mock
    private OrderService orderService;  // Mock de la couche service

    private OrderController orderController;

    @BeforeEach
    void setUp() {
        orderController = new OrderController(orderService);
    }

    @Test
    void testCreateOrder_callsServiceWithCorrectOrder() {
        // ARRANGE
        Order order = new Order("ORD-001", "Laptop", 2);

        // ACT
        orderController.createOrder(order);

        // VERIFY : OrderService.createOrder a été appelé avec le bon objet
        verify(orderService, times(1)).createOrder(order);
    }

    @Test
    void testCreateOrder_serviceCallsDao() {
        // Dans ce test, on teste la chaîne OrderService → OrderDao
        // On crée un vrai OrderService avec un mock OrderDao
        OrderService realOrderService = new OrderService(orderDao);
        OrderController controller = new OrderController(realOrderService);

        Order order = new Order("ORD-002", "Mouse", 5);

        // ACT
        controller.createOrder(order);

        // VERIFY : OrderDao.saveOrder a été appelé avec le bon objet commande
        verify(orderDao, times(1)).saveOrder(order);
    }

    @Test
    void testCreateOrder_isCalledExactlyOnce() {
        Order order = new Order("ORD-003", "Keyboard", 1);

        orderController.createOrder(order);

        // VERIFY : createOrder n'est appelé qu'une seule fois (pas de duplication)
        verify(orderService, times(1)).createOrder(order);
        verifyNoMoreInteractions(orderService);
    }
}