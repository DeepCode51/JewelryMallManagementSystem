package com.test.service;

import com.test.obj.Order;

import java.util.List;

public interface OrderService {
    int insert(Order order);
    int updateorder(Order order);
    List<Order> list(Order order);
}
