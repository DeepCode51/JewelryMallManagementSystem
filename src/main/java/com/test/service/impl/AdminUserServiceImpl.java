package com.test.service.impl;

import com.test.dao.AdminGoodsMapper;
import com.test.dao.AdminUserMapper;
import com.test.obj.*;
import com.test.service.AdminGoodsService;
import com.test.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;


    @Override
    public ResultMap<List<User>> list_user(Page page, int stat) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stat", stat);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        List<User> list = adminUserMapper.list_user(map);
        int count = adminUserMapper.count(stat);

        ResultMap<List<User>> jsonMap = new ResultMap<List<User>>(0, "success", count, list);
        return jsonMap;
    }

    @Override
    public ResultMap<List<User>> search(Page page, String username, int stat) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stat", stat);
        map.put("start", page.getStart());
        map.put("rows", page.getRows());
        map.put("username", username);
        List<User> list = adminUserMapper.search_name(map);
        int count =adminUserMapper.count_name(username);
        ResultMap<List<User>> jsonMap = new ResultMap<List<User>>(0, "success", count, list);
        return jsonMap;
    }

    @Override
    public int update(User user) {
        return adminUserMapper.update(user);
    }

    @Override
    public int delete(String aid) {
        return adminUserMapper.delete(aid);
    }

    @Override
    public User search_aid(String aid) {
        return adminUserMapper.search_user(aid);
    }
}
