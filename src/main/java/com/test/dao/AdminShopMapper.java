package com.test.dao;

import com.test.obj.Page;
import com.test.obj.Shop;

import java.util.List;
import java.util.Map;

public interface AdminShopMapper {
    List<Shop> list_shop(Page page);
    int update_shop(Shop shop);
    int shop_delete(String sno);
    List<Shop> search_sname(Map<String, Object> map);
    Shop search_sno(String sno);
    int count(int flag);
    int batchDelete(List<String> list);
    String pic_url(String sno);
}
