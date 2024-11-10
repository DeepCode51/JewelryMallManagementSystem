package com.test.controller;

import com.test.obj.Admin;
import com.test.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login_index(){
        return "admin/login";
    }

    @RequestMapping("/login.do")
    public String login(String adminname, String password){
        Admin admin = new Admin();
        admin.setAdminname(adminname);
        admin.setPassword(password);
        if(adminService.login(admin)){
            return "admin/index";
        }else {
            return "redirect:/admin/login";
        }

    }
    @RequestMapping("/echart")
    public String echart(){
        return "admin/echart";
    }
    @RequestMapping("/echart.do")
    @ResponseBody
    public Map<String, Object> learnLayuiAndEchart() {
        /**
         * 直方图---展示每个星期的销售金额
         */
        // 设置 周数
        List<String> sale_weekList = new ArrayList<String>();
        sale_weekList.add("第1周");
        sale_weekList.add("第2周");
        sale_weekList.add("第3周");
        sale_weekList.add("第4周");
        // 设置 每周销售金额
        List<String> sale_feeList = new ArrayList<String>();
        sale_feeList.add("1000");
        sale_feeList.add("700");
        sale_feeList.add("800");
        sale_feeList.add("1200");
        // 封装 销售数据
        Map<String, Object> sale_data = new LinkedHashMap<String, Object>();
        sale_data.put("week", sale_weekList);
        sale_data.put("fee", sale_feeList);

        /**
         * 饼状图---销售总额 对比 广告总费用
         */
        Map<String, Object> saleTotalFee = new LinkedHashMap<String, Object>();
        saleTotalFee.put("name", "销售总额");
        saleTotalFee.put("value", "3700");
        Map<String, Object> adTotalFee = new LinkedHashMap<String, Object>();
        adTotalFee.put("name", "宣传费用");
        adTotalFee.put("value", "500");
        // 封装 总额数据
        List<Map<String, Object>> feeList = new ArrayList<Map<String,Object>>();
        feeList.add(saleTotalFee);
        feeList.add(adTotalFee);

        // 封装 数据
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("sale", sale_data);
        data.put("total", feeList);
        // 返回结果
        Map<String, Object> resMap = new LinkedHashMap<String, Object>();
        resMap.put("code", 0);
        resMap.put("data", data);
        resMap.put("msg", "成功获取到图表数据！");
        return resMap;
    }
}
