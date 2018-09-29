package com.hundsun.wallet.controller;

import com.hundsun.wallet.entity.TUserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/login")
    public String login(TUserEntity login, Model model){
        return "main";
    }
}
