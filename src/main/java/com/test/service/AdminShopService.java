package com.test.service;

import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Shop;

import java.util.List;

public interface AdminShopService {
    ResultMap<List<Shop>> list_shop(Page page);
    int update_shop(Shop shop);
    int shop_delete(String sno);
    ResultMap<List<Shop>> search_sname(Page page, String sname, int flag);
    Shop search_sno(String sno);
    int update_flag(int flag, String sno);
    int batchDetele(List<String> list);
    String pic_url(String sno);
}
