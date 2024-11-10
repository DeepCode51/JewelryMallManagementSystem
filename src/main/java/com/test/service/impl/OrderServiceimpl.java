package com.test.service.impl;

import com.test.dao.OrderMapper;
import com.test.dao.SeriesMapper;
import com.test.obj.Order;
import com.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int updateorder(Order order) {
        return orderMapper.updateorder(order);
    }

    @Override
    public List<Order> list(Order order) {
        return orderMapper.list(order);
    }
}
