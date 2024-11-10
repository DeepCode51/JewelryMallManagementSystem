package com.test.controller;

import com.test.obj.Goods;
import com.test.obj.Page;
import com.test.obj.ResultMap;
import com.test.obj.Series;
import com.test.service.AdminGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodController {

    @Autowired
    AdminGoodsService adminGoodsService;

    @RequestMapping("")
    public String index(){
        return "admin/goods";
    }

    @RequestMapping("/getseries")
    @ResponseBody
    public List<Series> getclassify(){
        return adminGoodsService.getSeries();
    }

    @RequestMapping("list_goods")
    @ResponseBody
    public ResultMap<List<Goods>> goods_list(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "")String gname){
        page.setRows(limit);
//        System.out.println("啦啦啦"+gname);
        if (gname.length()>0){
            return adminGoodsService.search(page,gname,1);
        }else {
            return adminGoodsService.list_goods(page, 1);
        }
    }

    @RequestMapping("/bySeries")
    @ResponseBody
    public ResultMap<List<Goods>> bySeries(@RequestParam("series") int series, @RequestParam("limit") int limit, Page page){
       page.setRows(limit);
        System.out.println("何回合"+limit+","+page.getRows());
        return adminGoodsService.bySeries(page,series);
    }

    @RequestMapping("/goods_app")
    public String app(){
        return "admin/goods_app";
    }

    @RequestMapping("/goods_app.do")
    @ResponseBody
    public ResultMap<List<Goods>> app_list(Page page, @RequestParam("limit") int limit, @RequestParam(value = "search", defaultValue = "")String gname){
        page.setRows(limit);
        System.out.println("啦啦啦"+gname);
        if (gname.length()>0){
            return adminGoodsService.search(page,gname,0);
        }else {
            return adminGoodsService.list_goods(page, 0);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public int update(Goods good){
        return adminGoodsService.update(good);
    }

    @RequestMapping("/edit")
    public String edit_h(@RequestParam("gno")String gno, Model model){
        Goods g = adminGoodsService.search_sno(gno);
        model.addAttribute("good", g);
        return "admin/good_edit";
    }

    @RequestMapping("/edit.do")
    @ResponseBody
    public int edit(Goods good){
        System.out.println(good.toString());
        return adminGoodsService.update(good);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(@RequestParam("gno")String gno){
        return adminGoodsService.delete(gno);
    }



    @RequestMapping("/qcert")
    @ResponseBody
    public String qcert_Url (@RequestParam("gno")String gno){
        return adminGoodsService.pic_url(gno);
    }


}
