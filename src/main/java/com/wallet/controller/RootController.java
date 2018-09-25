package com.wzh.demo.controller;

import com.sun.corba.se.spi.extension.CopyObjectPolicy;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wzh.demo.POJO.UserPojo;
import com.wzh.demo.dao.UserDao;
import com.wzh.demo.dao.WalletDao;
import com.wzh.demo.entity.UserEntity;
import com.wzh.demo.entity.WalletEntity;
import com.wzh.demo.service.UserService;
import com.wzh.demo.utils.CustomException;
import com.wzh.demo.utils.MD5Utils;
import com.wzh.demo.utils.StautsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;

@Controller
@RequestMapping("")
//TODO 前台反映后台处理结果
public class RootController {

    @Autowired
    private UserService userService;

    //index
    @RequestMapping("/index.do")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    //跳转到注册页面
    @RequestMapping("/do_register.do")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("register");
        return  modelAndView;
    }

    //登录
    @RequestMapping("login.do")
    public ModelAndView login(UserPojo userPojo,HttpServletResponse response, HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView("login");
        if(userPojo != null){
            String result = this.userService.login(userPojo,session);
            if(result.equals(StautsUtils.OPERATION_SUCCESS)){
                modelAndView.setViewName("redirect:/user.details.do");
            }else {
                new CustomException(result);
                response.getWriter().write(result);
            }
        }
        return modelAndView;
    }

    //注册
    @RequestMapping("register.do")
    public ModelAndView register(UserPojo userPojo , HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("register");
        if(userPojo != null){
            String result = this.userService.register(userPojo);
            if(result.equals(StautsUtils.OPERATION_SUCCESS)){//注册成功时返回true
                modelAndView.setViewName("login");
            }else {
                new CustomException(result);
                response.getWriter().write(result);
            }
        }
        return modelAndView;
    }

}
