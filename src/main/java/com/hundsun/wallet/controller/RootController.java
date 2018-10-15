package com.hundsun.wallet.controller;

import com.hundsun.wallet.entity.UserEntity;
import com.hundsun.wallet.entity.UserInfoEntity;
import com.hundsun.wallet.entity.WalletEntity;
import com.hundsun.wallet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class RootController {

    @Resource
    private UserService userService;

    @RequestMapping("")
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/login")
    public String login(UserEntity user, Model model){
        boolean success = false;
        if (user != null ){
            success = this.userService.login(user);
        }
        if (success){
            model.addAttribute("user",user);
            return "main";
        }else {
            model.addAttribute("errorMessage","账号或密码错误！");
            return "login";
        }
    }

    @RequestMapping(value = "/sign_up")
    public String signUp(UserEntity user, WalletEntity walletEntity, UserInfoEntity userInfoEntity, Model model){
        boolean success = false;
        if (user != null){
            success = this.userService.register(user, walletEntity, userInfoEntity);
        }
        if (success){
            return "login";
        }
        return "register";
    }

}
