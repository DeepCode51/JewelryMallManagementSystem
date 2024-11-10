package com.test.dao;

import com.test.obj.Order;

import java.util.List;

public interface OrderMapper {
    int insert(Order order);
    int updateorder(Order order);
    List<Order> list(Order order);
}
