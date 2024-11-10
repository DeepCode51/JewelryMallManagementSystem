package com.test.service;

import com.test.obj.*;

import java.util.List;

public interface ShopService {
    Shop login(Shop shop1);
    int insert(Shop shop1);
    Shop findone(Shop shop1);
    int update(Shop shop1);
    List<Goods> loadgoods(Goods goods);
    List<Classify> loadtype();
    int updateicon(Shop shop);
}
