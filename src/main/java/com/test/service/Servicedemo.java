package com.test.service;

import com.test.dao.UserMapper;
import com.test.obj.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Servicedemo {
//    public static void main(String[] args) throws IOException {
//        User user1 = new User();
//        user1.setAid("1290816059");
//        user1.setUserpass("123456");
//
//        InputStream resourceAsStream = Resources.getResourceAsStream("Sqlmapperconfig.xml");
//        //获得session工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        //获得Session会话对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper Mapper= sqlSession.getMapper(UserMapper.class);
//        List<User> all = Mapper.findAll();
//        System.out.println(all);
//
//        User u1 = Mapper.login(user1);
//        System.out.println(u1);

}
