package com.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Shop;
import com.test.service.AdminShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/shop")
public class AdminShopController {
    @Autowired
    private AdminShopService adminShopService;

    @RequestMapping("/shop_list.do")
    @ResponseBody
    public ResultMap<List<Shop>> shop_list(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "") String sname){
        page.setRows(limit);
        page.setFlag(1);
        trans_list();
        if (sname.length()>0){

            return adminShopService.search_sname(page, sname, 1);
        }else {
            return adminShopService.list_shop(page);
        }

    }

    @RequestMapping("/shop_list")
    public String trans_list(){
        return "admin/shop_list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int shop_delete(@RequestParam("sno") String sno){
        return adminShopService.shop_delete(sno);
    }

    @RequestMapping("/shop_edit")
    public String shop_edit_h(@RequestParam("sno") String sno, Model model){
        Shop res = adminShopService.search_sno(sno);
        model.addAttribute("shop", res);
        return "admin/shop_edit";
    }

    @RequestMapping("/shop_edit.do")
    @ResponseBody
    public int  shop_edit(Shop shop){
        return  adminShopService.update_shop(shop);
    }

    @RequestMapping("/shop_app")
    public String trans_app(){
        return "admin/shop_app";
    }

    @RequestMapping("/shop_app.do")
    @ResponseBody
    public ResultMap<List<Shop>> shop_app(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "") String sname){
        page.setRows(limit);
        page.setFlag(1);
        trans_app();
        if (sname.length()>0){
            return adminShopService.search_sname(page, sname, 1);
        }else {
            return adminShopService.list_shop(page);
        }
    }

    @RequestMapping("/update_flag")
    @ResponseBody
    public int update_flag(@RequestParam("flag") int flag, @RequestParam("sno") String sno){
        return adminShopService.update_flag(flag, sno);
    }

//    @RequestMapping("/refresh")
//    public void refresh(Page page){
//        adminShopService.list_shop(page)
//    }

    @RequestMapping("/qcert")
    @ResponseBody
    public String qcert_Url (@RequestParam("sno")String sno){
        System.out.println(adminShopService.pic_url(sno));
        return adminShopService.pic_url(sno);
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public int batchDelete(@RequestParam(value = "snos") String snos){
        List<String> list = JSONArray.parseArray(snos,String.class);
        return adminShopService.batchDetele(list);

    }





}
