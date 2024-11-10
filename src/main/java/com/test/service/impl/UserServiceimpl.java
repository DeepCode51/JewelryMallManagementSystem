package com.test.service.impl;

import com.test.dao.UserMapper;
import com.test.obj.Like;
import com.test.obj.User;
import com.test.service.UserService;
import com.test.tool.UploadTool;
import com.test.tool.UrlEnum;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public User login(User u1) {
        return userMapper.login(u1);
    }

    @Override
    public int insert(User u1) {
        return userMapper.insert(u1);
    }

    @Override
    public int updateicon(User u1) {
        return userMapper.updateicon(u1);
    }

    @Override
    public int updatemoney(User u1) {
        return userMapper.updatemoney(u1);
    }

    @Override
    public int delete(User u1) {
        return 0;
    }

    @Override
    public User findone(User u1) {
        return userMapper.findone(u1);
    }

    @Override
    public int editinfo(User u1) {
        return userMapper.editinfo(u1);
    }

    @Override
    public int addlike(Like like) {
        return userMapper.addlike(like);
    }

    @Override
    public int removelike(Like like) {
        return userMapper.removelike(like);
    }

    @Override
    public List<Like> listlike(Like u1) {
        return userMapper.listlike(u1);
    }


}
