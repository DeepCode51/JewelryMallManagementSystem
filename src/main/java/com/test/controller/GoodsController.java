package com.test.controller;

import com.test.obj.*;
import com.test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/good")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SeriesSerice seriesSerice;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopService shopService;
    @RequestMapping("/series")
    public String series(Model model,@RequestParam("seriesid") Integer seriesid ){
        Goods g1 = new Goods();
        g1.setSeriesid(seriesid);
        Lunbo l1 = new Lunbo();
        l1.setSeriesid(seriesid);
        List<Goods> goodsList = goodsService.loadseries(g1);
        List<Lunbo> lunboList = seriesSerice.listlunbo(l1);
        model.addAttribute("goodlist",goodsList);
        model.addAttribute("lunbolist",lunboList);
        return "goods_series";
    }
    @RequestMapping("/buy")
    public String goods(Model model, @RequestParam("gno") String gno , HttpServletRequest request) {
        String UserId= (String) request.getSession().getAttribute("userId");
        if (UserId!=null){
            User u1 =new User();
            u1.setAid(UserId);
            User u2 = userService.findone(u1);
            model.addAttribute("user1",u2);
            Goods g1 = new Goods();
            g1.setGno(gno);
            Goods goods = goodsService.loadgoods(g1);
            Img img1 = goodsService.loadimg(g1);
            model.addAttribute("img1",img1);
            model.addAttribute("good",goods);
            return "goods_buy";
        }else{
            return "user_loginreg";
        }

    }
    @RequestMapping("/buygood")
    public String buygood(Model model, String gno, String pname, String place, String gname, String gbig, String price, String call, String gurl, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String UserId= (String) request.getSession().getAttribute("userId");
        float price1 = Float.parseFloat(price);
        User u1 = new User();
        u1.setAid(UserId);
//        对比钱是否够
        User u2 = new User();
        u2= userService.findone(u1);
        float money = u2.getMoney();
        float finallymoney = money-price1;

        if (finallymoney>=0){
            u2.setMoney(finallymoney);
            userService.updatemoney(u2);
            Order o1 = new Order();
            o1.setGno(gno);
            o1.setUid(UserId);
            o1.setGname(gname);
            o1.setGprice(price1);
            o1.setPname(pname);
            o1.setOplace(place);
            o1.setGbig(gbig);
            o1.setPcall(call);
            o1.setStat("已付款");
            o1.setOurl(gurl);
            int res = orderService.insert(o1);

            //        把钱放到商家里
//        1、找到商家id 2、找到商家的钱 3、把新的钱写到商家里
            Goods g1 =new Goods();
            g1.setGname(gname);
            Goods g2= goodsService.search(g1);//获取该商品的全部信息
            Shop shop1= new Shop();
            shop1.setSno(g2.getShopid());//获得该商品的商家id
            Shop shop2= shopService.findone(shop1);//查找该商家的所有信息包括money
            float shopmoney = shop2.getMoney()+price1;//商家的钱+新的收入钱
            Shop shop3 = new Shop();//准备写入新的钱
            shop3.setSno(g2.getShopid());//准备好该商家
            shop3.setMoney(shopmoney);//准备好钱
            shopService.update(shop3);//写入！！

            return "redirect:/user/index";
        }else{
//            余额不足！
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript'>alert('支付失败!');history.go(-1)</script>");
            out.flush();
            out.close();
            return "redirect:/user/index";
        }

    }
}
