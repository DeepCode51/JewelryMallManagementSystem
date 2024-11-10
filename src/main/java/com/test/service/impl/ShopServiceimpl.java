package com.test.service.impl;

import com.test.dao.SeriesMapper;
import com.test.dao.ShopMapper;
import com.test.obj.Classify;
import com.test.obj.Goods;
import com.test.obj.Shop;
import com.test.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceimpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Override
    public Shop login(Shop shop1) {
        return shopMapper.login(shop1);
    }

    @Override
    public int insert(Shop shop1) {
        return shopMapper.insert(shop1);
    }

    @Override
    public Shop findone(Shop shop1) {
        return shopMapper.findone(shop1);
    }

    @Override
    public int update(Shop shop1) {
        return shopMapper.update(shop1);
    }

    @Override
    public List<Goods> loadgoods(Goods goods) {
        return shopMapper.loadgoods(goods);
    }

    @Override
    public List<Classify> loadtype() {
        return shopMapper.loadtype();
    }

    @Override
    public int updateicon(Shop shop) {
        return shopMapper.updateicon(shop);
    }
}
