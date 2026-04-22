// src/main/java/dao/OrderDao.java
package dao;

import model.Order;

public interface OrderDao {
    void saveOrder(Order order);
}