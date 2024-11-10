package com.test.dao;

import com.test.obj.Goods;
import com.test.obj.Img;

import java.util.List;

public interface GoodsMapper {
    List<Goods> loadseries(Goods goods);
    Goods loadgoods(Goods goods);
    Img loadimg(Goods goods);
    int insert(Goods goods);
    Goods search(Goods goods);
}
