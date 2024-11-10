package com.test.service;

import com.test.obj.*;

import java.util.List;

public interface AdminUserService {
    ResultMap<List<User>> list_user(Page page, int stat);
    ResultMap<List<User>> search(Page page, String username, int stat);
    int update(User user);
    int delete(String aid);
    User search_aid(String aid);
}
