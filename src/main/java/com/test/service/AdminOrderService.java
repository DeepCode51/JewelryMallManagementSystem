package com.test.service;

import com.test.obj.Order;
import com.test.obj.Page;
import com.test.obj.ResultMap;

import java.util.List;

public interface AdminOrderService {
    ResultMap<List<Order>> list_order(Page page);
    ResultMap<List<Order>> search(Page page, int oid);
    int update(Order order);
}
