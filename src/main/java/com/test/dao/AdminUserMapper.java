package com.test.dao;

import com.test.obj.Goods;
import com.test.obj.Series;
import com.test.obj.User;

import java.util.List;
import java.util.Map;

public interface AdminUserMapper {
    List<User> list_user(Map<String, Object> map);
    List<User> search_name(Map<String, Object> map);
    int update(User user);
    int count(int stat);
    int count_name(String username);
    User search_user(String aid);
    int delete(String aid);
}
