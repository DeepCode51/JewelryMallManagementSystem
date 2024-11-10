package com.test.service.impl;

import com.test.dao.AdminShopMapper;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Shop;
import com.test.service.AdminShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminShopServiceImpl implements AdminShopService {
    @Autowired
    AdminShopMapper adminShopMapper;

    @Override
    @Transactional
    public int batchDetele(List<String> list) {
        return adminShopMapper.batchDelete(list);
    }

    @Override
    public String pic_url(String sno) {
        return "../../img/scert/"+adminShopMapper.pic_url(sno);
    }

    @Override
    public ResultMap<List<Shop>> list_shop(Page page){
        List<Shop> list = adminShopMapper.list_shop(page);
        int count = adminShopMapper.count(page.getFlag());
        ResultMap<List<Shop>> jsonMap = new ResultMap<List<Shop>>(0, "success", count, list);
        return  jsonMap;
    }

    @Override
    public int update_flag(int flag, String sno) {
        Shop shop = new Shop();
        shop.setFlag(flag);
        shop.setSno(sno);
        return adminShopMapper.update_shop(shop);
    }

    @Override
    public int update_shop(Shop shop) {
        int r = 0;
        try {
            r = adminShopMapper.update_shop(shop);
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public ResultMap<List<Shop>> search_sname(Page page, String sname, int flag) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sname", sname);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        map.put("flag",flag);
        List<Shop> list = adminShopMapper.search_sname(map);
        int count = adminShopMapper.count(flag);
        ResultMap<List<Shop>> jsonMap = new ResultMap<List<Shop>>(0, "success", count, list);
        return jsonMap;
    }

    @Override
    public int shop_delete(String sno) {
        return adminShopMapper.shop_delete(sno);
    }

    @Override
    public Shop search_sno(String sno) {
        return adminShopMapper.search_sno(sno);
    }
}
