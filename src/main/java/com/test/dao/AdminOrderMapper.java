package com.test.dao;

import com.test.obj.Order;
import com.test.obj.Page;

import java.util.List;
import java.util.Map;

public interface AdminOrderMapper {
    List<Order> list_order(Page page);
    int count();
    int count_id(int oid);
    List<Order> search_id(Map<String, Object> map);
    int update(Order order);
}
