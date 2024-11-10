package com.test.service.impl;

import com.test.dao.AdminMapper;
import com.test.obj.Admin;
import com.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public boolean login(Admin admin) {
        Admin admin_search = adminMapper.login(admin);
        if (admin_search == null){
            return false;
        }
        return admin.getPassword().equals(admin_search.getPassword());
    }

}
