package com.test.controller;

import com.test.obj.*;
import com.test.service.GoodsService;
import com.test.service.OrderService;
import com.test.service.SeriesSerice;
import com.test.service.UserService;
import com.test.tool.UploadTool;
import com.test.tool.UrlEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SeriesSerice seriesSerice;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    //默认登陆欢迎页
    @RequestMapping("/welcome")
    public String welcome(){

        return "user_login";
    }
    @RequestMapping("/myinfo")
    public String myinfo(Model model,HttpServletRequest request) {
        String UserId= (String) request.getSession().getAttribute("userId");
        if (UserId!=null){
            User u1 =new User();
            u1.setAid(UserId);
            User u2 = userService.findone(u1);
            model.addAttribute("user",u2);
            Order o1 = new Order();
            o1.setUid(UserId);
            List<Order> orderList = orderService.list(o1);
            model.addAttribute("orderlist",orderList);
            Like l1 = new Like();
            l1.setUid(UserId);
            List<Like>likeList = userService.listlike(l1);
            model.addAttribute("likelist",likeList);
            return "user_my";
        }else{
            return "user_loginreg";
        }

    }
    @RequestMapping("/addlike")
    public String addlike(Model model,HttpServletRequest request,@RequestParam("gno") String gno,
            @RequestParam("url1") String url1,@RequestParam("gname") String gname){
        String UserId= (String) request.getSession().getAttribute("userId");
        Like l1= new Like();
        l1.setGno(gno);
        l1.setGname(gname);
        l1.setUrl(url1);
        l1.setUid(UserId);
        userService.addlike(l1);
        return "redirect:/user/myinfo";
    }
    @RequestMapping("/removelike")
    public String remove(Model model,HttpServletRequest request,@RequestParam("gno") String gno){
        String UserId= (String) request.getSession().getAttribute("userId");
        Like l1 = new Like();
        l1.setUid(UserId);
        l1.setGno(gno);
        userService.removelike(l1);
        return "redirect:/user/myinfo";
    }
    @RequestMapping("/updateorder")
    public String updateorder(Model model,HttpServletRequest request,@RequestParam("oid") int oid){
        Order o1 = new Order();
        o1.setOid(oid);
        orderService.updateorder(o1);
        return "redirect:/user/myinfo";
    }
    @RequestMapping("/index")
    public String index(Model model,HttpServletRequest request){
        List<Series> series = seriesSerice.list();
        model.addAttribute("serieslist",series);
//        request.getSession().setAttribute("msg", "");
//        System.out.println(series.get(0));
        return "user_index";
    }
    @RequestMapping("/login")
    public String login(String aid , String userpass , Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{

        User u1 = new User();
        u1.setAid(aid);
        u1.setUserpass(userpass);
        User u2 = userService.login(u1);
        if (u2.getAble()==0){
            if(u2!=null){
                request.getSession().setAttribute("flag", "");
                request.getSession().setAttribute("userId", u2.getAid());
                return "redirect:/user/index";
            }else{
//            map.put("flag","用户名或密码错误！");
                request.getSession().setAttribute("flag", "用户名或密码错误！");
                return "user_loginreg";
            }
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript'>alert('该账号无权限!');history.go(-1)</script>");
            out.flush();
            out.close();
            return "user_loginreg";
        }

    }
    @RequestMapping("/editinfo")
    public String editinfo(String sex , String username ,String call,String place ,Model model, HttpServletRequest request) throws IOException{
        String UserId= (String) request.getSession().getAttribute("userId");
        User u1 = new User();
        u1.setAid(UserId);
        u1.setSex(sex);
        u1.setUsername(username);
        u1.setCall(call);
        u1.setPlace(place);
        int u2 = userService.editinfo(u1);

        return "redirect:/user/myinfo";
    }
    @RequestMapping("/reg")
    public String regindex(String sex , String aid , String username , String userpass , String call , String timerr , Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, IOException{
//        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        User u1 = new User();
        u1.setAid(aid);
        u1.setSex(sex);
        u1.setUsername(username);
        u1.setUserpass(userpass);
        u1.setCall(call);
        u1.setCreatetime(timerr);
        int flag = userService.insert(u1);
        if (flag>0) {
//            out.print("<script>alert('注册成功！');</script>");
            request.getSession().setAttribute("reg", "true");
            return "redirect:/user/welcome";
        }else {
            return "redirect:/user/welcome";
        }
    }
    @RequestMapping("/search")
    public String search(String find,Model model){
        Goods g1 = new Goods();
        g1.setGname(find);
        Goods g2 = goodsService.search(g1);
        String gno = g2.getGno();
        System.out.println(g2);
//        model.addAttribute("good1",g2);
        return "redirect:/good/buy?gno="+gno;
    }
    @RequestMapping("/loginout")
    public String logout(HttpServletRequest request) throws IOException {
        HttpSession session=request.getSession();
        session.invalidate();
        return "user_login";

    }
    @RequestMapping("/uploadicon")
    public String uploadicon(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String UserId= (String) request.getSession().getAttribute("userId");
        User u1 =new User();
        String iconname=null;
        try{
           iconname=UploadTool.upload(file, UrlEnum.User_icon.getUrl());
        }catch(Exception e){

        }
        u1.setAid(UserId);
        u1.setIcon(iconname);
        int i = userService.updateicon(u1);
        return "redirect:/user/myinfo";

    }
//    @RequestMapping("/list")
//    public ModelAndView list(){
//       List<User>userList= userService.list();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("userList",userList);
//        modelAndView.setViewName("userList");
//        return modelAndView;
//    }


}
