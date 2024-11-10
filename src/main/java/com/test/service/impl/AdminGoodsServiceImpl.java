package com.test.service.impl;

import com.test.dao.AdminGoodsMapper;
import com.test.obj.Goods;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Series;
import com.test.service.AdminGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {
    @Autowired
    AdminGoodsMapper adminGoodsMapper;

    @Override
    public List<Series> getSeries() {
        return adminGoodsMapper.getSeries();
    }

    @Override
    public ResultMap<List<Goods>> bySeries(Page page, int series) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("series", series);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Goods> list = adminGoodsMapper.bySeries(map);
        int count = adminGoodsMapper.count_series(series);
        ResultMap<List<Goods>> jsonMap = new ResultMap<List<Goods>>(0, "success", count, list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<Goods>> list_goods(Page page, int stat) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stat", stat);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<Goods> list = adminGoodsMapper.list_goods(map);
        int count = adminGoodsMapper.count(stat);

        ResultMap<List<Goods>> jsonMap = new ResultMap<List<Goods>>(0, "success", count, list);
        return jsonMap;

    }

    @Override
    public ResultMap<List<Goods>> search(Page page, String gname, int stat) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stat", stat);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        map.put("gname", gname);
        List<Goods> list = adminGoodsMapper.search_name(map);
        int count = adminGoodsMapper.count_name(gname);
        ResultMap<List<Goods>> jsonMap = new ResultMap<List<Goods>>(0, "success", count, list);
        return jsonMap;
    }

    @Override
    public int update(Goods good) {
        return adminGoodsMapper.update(good);
    }

    @Override
    @Transactional
    public int delete(String gno) {
        adminGoodsMapper.delete_img(gno);
        return adminGoodsMapper.delete(gno);
    }

    @Override
    public String pic_url(String gno) {
        return "../../img/zs/"+ adminGoodsMapper.pic_url(gno);
    }

    @Override
    public Goods search_sno(String gno) {
        return adminGoodsMapper.search_good(gno);
    }
}
