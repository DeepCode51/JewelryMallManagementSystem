package com.test.service.impl;

import com.test.dao.AdminOrderMapper;
import com.test.obj.Order;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    AdminOrderMapper adminOrderMapper;

    @Override
    public ResultMap<List<Order>> list_order(Page page) {
        List<Order> list = adminOrderMapper.list_order(page);
        int count = adminOrderMapper.count();
        ResultMap<List<Order>> jsonMap = new ResultMap<List<Order>>(0, "success", count, list);
        return  jsonMap;
    }

    @Override
    public ResultMap<List<Order>> search(Page page, int oid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oid", oid);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Order> list = adminOrderMapper.search_id(map);
        int count = adminOrderMapper.count_id(oid);
        ResultMap<List<Order>> jsonMap = new ResultMap<List<Order>>(0, "success", count, list);
        return jsonMap;
    }

    @Override
    public int update(Order order) {
        return adminOrderMapper.update(order);
    }
}
