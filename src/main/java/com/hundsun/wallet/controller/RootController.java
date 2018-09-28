package com.hundsun.wallet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class RootController {

//    @Autowired
//    private UserService userService;

    //自动跳转
    @RequestMapping("")
    public String index(){
        return "login";
    }
//    //index
//    @RequestMapping("/index")
//    public ModelAndView index(){
//        ModelAndView modelAndView = new ModelAndView("login");
//        return modelAndView;
//    }
//
//    //跳转到注册页面
//    @RequestMapping("/do_register")
//    public ModelAndView register(){
//        ModelAndView modelAndView = new ModelAndView("register");
//        return  modelAndView;
//    }
//
//    //登录
//    @RequestMapping("login.do")
//    public ModelAndView login(UserPojo userPojo,HttpServletResponse response, HttpSession session) throws Exception {
//        ModelAndView modelAndView = new ModelAndView("login");
//        if(userPojo != null){
//            String result = this.userService.login(userPojo,session);
//            if(result.equals(StautsUtils.OPERATION_SUCCESS)){
//                modelAndView.setViewName("redirect:/user.details.do");
//            }else {
//                new CustomException(result);
//                response.getWriter().write(result);
//            }
//        }
//        return modelAndView;
//    }
//
//    //注册
//    @RequestMapping("register.do")
//    public ModelAndView register(UserPojo userPojo , HttpServletResponse response) throws Exception {
//        ModelAndView modelAndView = new ModelAndView("register");
//        if(userPojo != null){
//            String result = this.userService.register(userPojo);
//            if(result.equals(StautsUtils.OPERATION_SUCCESS)){//注册成功时返回true
//                modelAndView.setViewName("login");
//            }else {
//                new CustomException(result);
//                response.getWriter().write(result);
//            }
//        }
//        return modelAndView;
//    }
//
}
