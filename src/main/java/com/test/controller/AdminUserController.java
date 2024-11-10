package com.test.controller;

import com.test.obj.User;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Series;
import com.test.service.AdminGoodsService;
import com.test.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping("")
    public String index(){
        return "admin/user";
    }

    @RequestMapping("list_user")
    @ResponseBody
    public ResultMap<List<User>> User_list(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "")String username){
        page.setRows(limit);
//        System.out.println("啦啦啦"+gname);
        if (username.length()>0){
            return adminUserService.search(page,username,1);
        }else {
            return adminUserService.list_user(page, 1);
        }
    }



    @RequestMapping("/update")
    @ResponseBody
    public int update(User user){
        return adminUserService.update(user);
    }

    @RequestMapping("/edit")
    public String edit_h(@RequestParam("aid")String aid, Model model){
        User g = adminUserService.search_aid(aid);
        model.addAttribute("user", g);
        return "admin/user_edit";
    }

    @RequestMapping("/edit.do")
    @ResponseBody
    public int edit(User user){
        System.out.println(user.toString());
        return adminUserService.update(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(@RequestParam("aid")String aid){
        return adminUserService.delete(aid);
    }

}
