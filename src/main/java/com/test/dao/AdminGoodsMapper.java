package com.test.dao;

import com.test.obj.Goods;
import com.test.obj.Series;

import java.util.List;
import java.util.Map;

public interface AdminGoodsMapper {
    List<Series> getSeries();
    List<Goods> list_goods(Map<String, Object> map);
    int count(int stat);
    List<Goods> bySeries(Map<String, Object> map);
    int count_series(int series);
    List<Goods> search_name(Map<String, Object> map);
    int count_name(String gname);
    int update(Goods good);
    Goods search_good(String gno);
    int delete(String gno);
    int delete_img(String gno);
    String pic_url(String gno);
}
