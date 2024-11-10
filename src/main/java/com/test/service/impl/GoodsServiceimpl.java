package com.test.service.impl;

import com.test.dao.GoodsMapper;
import com.test.obj.Goods;
import com.test.obj.Img;
import com.test.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceimpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> loadseries(Goods goods) {
        return goodsMapper.loadseries(goods);
    }

    @Override
    public Goods loadgoods(Goods goods) {
        return goodsMapper.loadgoods(goods);
    }

    @Override
    public Img loadimg(Goods goods) {
        return goodsMapper.loadimg(goods);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Goods search(Goods goods) {
        return goodsMapper.search(goods);
    }


}
