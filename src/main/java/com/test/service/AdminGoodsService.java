package com.test.service;

import com.test.obj.Goods;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Series;

import java.util.List;

public interface AdminGoodsService {
    List<Series> getSeries();
    ResultMap<List<Goods>> list_goods(Page page, int stat);
    ResultMap<List<Goods>> bySeries(Page page, int series);
    ResultMap<List<Goods>> search(Page page, String gname, int stat);
    int update(Goods good);
    Goods search_sno(String gno);
    int delete(String gno);
    String pic_url(String gno);
}
