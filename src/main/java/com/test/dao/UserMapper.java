package com.test.dao;

import com.test.obj.Like;
import com.test.obj.User;

import java.util.List;

public interface UserMapper {
    List<User> list();
    User login(User u1);
    int insert(User u1);
    int updateicon(User u1);
    int updatemoney(User u1);
    int delete(User u1);
    User findone(User u1);
    int editinfo(User u1);
    int addlike(Like like);
    int removelike(Like like);
    List<Like> listlike(Like u1);
}
