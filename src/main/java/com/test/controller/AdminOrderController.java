package com.test.controller;

import com.test.obj.Order;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.service.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {
    @Autowired
    AdminOrderService adminOrderService;

    @RequestMapping("")
    public String index() {
        return "admin/orders";
    }

    @RequestMapping("/list_order")
    @ResponseBody
    public ResultMap<List<Order>> list_order(@RequestParam("limit") int limit, Page page, @RequestParam(value = "search", defaultValue = "") Integer oid) {
        page.setRows(limit);
        if (oid != null) {
            return adminOrderService.search(page, oid);
        } else {
            return adminOrderService.list_order(page);
        }



    }
    @RequestMapping("/update")
    @ResponseBody
    public int update (Order order){
        return adminOrderService.update(order);
    }
}
