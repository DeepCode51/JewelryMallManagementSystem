package com.test.controller;

import com.test.obj.*;
import com.test.service.GoodsService;
import com.test.service.SeriesSerice;
import com.test.service.ShopService;
import com.test.service.UserService;
import com.test.tool.UploadTool;
import com.test.tool.UrlEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private SeriesSerice seriesSerice;
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/welcome")
    public String welcome(){

        return "shop_login";
    }
    @RequestMapping("/login")
    public String login(String aid , String userpass , Model model, HttpServletRequest request) throws IOException {
        Shop  s1 = new Shop();
        s1.setSno(aid);
        s1.setSpass(userpass);
        Shop s2 = shopService.login(s1);
        if(s2!=null){
            request.getSession().setAttribute("flag", "");
            request.getSession().setAttribute("shopId", s2.getSno());
            return "redirect:/shop/index";
        }else{
//            map.put("flag","用户名或密码错误！");
            request.getSession().setAttribute("flag", "用户名或密码错误！");
            return "redirect:/shop/welcome";
        }
    }
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        String shopsno= (String) request.getSession().getAttribute("shopId");
            Shop s1= new Shop();
            s1.setSno(shopsno);
            Shop s2 = shopService.findone(s1);
            model.addAttribute("shop",s2);
        Goods g1 = new Goods();
        g1.setShopid(shopsno);
        List<Goods> goodsList = shopService.loadgoods(g1);
        List<Classify> classifyList = shopService.loadtype();
        List<Series> seriesList = seriesSerice.list();
        model.addAttribute("goodlist",goodsList);
        model.addAttribute("typelist",classifyList);
        model.addAttribute("serieslist",seriesList);
        return "shop_index";
    }
    @RequestMapping("/reg")
    public String regindex(Shop shop , Model model, HttpServletRequest request) throws IOException, IOException{
//        response.setContentType("text/html;charset=gb2312");

        int flag = shopService.insert(shop);
        if (flag>0) {
//            out.print("<script>alert('注册成功！');</script>");
            request.getSession().setAttribute("reg", "true");
            return "redirect:/shop/welcome";
        }else {
            return "redirect:/shop/welcome";
        }
    }
    @RequestMapping("/editinfo")
    public String editinfo(Shop shop ,Model model, HttpServletRequest request) throws IOException{

        int fl = shopService.update(shop);
        return "redirect:/shop/index";
    }
    @RequestMapping("/addgoods")
    public String addgoods(Goods goods ,Model model, HttpServletRequest request) throws IOException{
        String shopsno= (String) request.getSession().getAttribute("shopId");
        goods.setShopid(shopsno);
        int f1 = goodsService.insert(goods);
        return "redirect:/shop/index";
    }
    @RequestMapping("/loginout")
    public String logout(HttpServletRequest request) throws IOException {
        HttpSession session=request.getSession();
        session.invalidate();
        return "shop_login";
    }
    @RequestMapping("/uploadicon")
    public String uploadicon(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String shopsno= (String) request.getSession().getAttribute("shopId");
        Shop s1 = new Shop();
        String iconname=null;
        try{
            iconname= UploadTool.upload(file, UrlEnum.Shop_icon.getUrl());
        }catch(Exception e){

        }
        s1.setSno(shopsno);
        s1.setScert(iconname);
        int i = shopService.updateicon(s1);
        return "redirect:/shop/index";

    }
    @RequestMapping("/upgoodicon")
    public String upgoodicon(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String shopsno= (String) request.getSession().getAttribute("shopId");
        Shop s1 = new Shop();
        String iconname=null;
        try{
            iconname= UploadTool.upload(file, UrlEnum.Shop_icon.getUrl());
        }catch(Exception e){

        }
        s1.setSno(shopsno);
        s1.setScert(iconname);
        int i = shopService.updateicon(s1);
        return "redirect:/shop/index";

    }
}
