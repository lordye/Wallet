package com.wzh.demo.controller;

import com.wzh.demo.POJO.UserPojo;
import com.wzh.demo.entity.TransferInfoEntity;
import com.wzh.demo.entity.UserEntity;
import com.wzh.demo.entity.WalletEntity;
import com.wzh.demo.service.TransferService;
import com.wzh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransferService transferService;


    //输入金额（包括转账和存取款）
    @RequestMapping("balance.do")
    public ModelAndView balance(@RequestParam("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        if(id != null){
            UserPojo userPojo = new UserPojo();
            userPojo.setId(Long.valueOf(id));
            modelAndView.addObject("toUser",userPojo);
            modelAndView.setViewName("transfer");
            return modelAndView;
        }

        return modelAndView;
    }


    //转账
    @RequestMapping("newBalance.do")
    public ModelAndView newTransfer(UserPojo userPojo, @SessionAttribute("loginUser") UserEntity loginUser){
        ModelAndView modelAndView = new ModelAndView();
        if(userPojo != null){
            UserEntity out = this.userService.getById(loginUser.getId());
            UserEntity in = this.userService.getById(userPojo.getId());
            if(this.transferService.transfer(in,out,userPojo.getBalance()))
                this.transferService.addTransfer(in,out,userPojo.getBalance());
            modelAndView.setViewName("redirect:/mine.do?id="+loginUser.getId());
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main.do");
        return modelAndView;
    }

    //存钱
    @RequestMapping("transferIn.do")
    public ModelAndView transferIn(UserPojo userPojo){
        ModelAndView modelAndView = new ModelAndView();
        if(userPojo != null){
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userPojo.getId());
            this.transferService.saveMoney(userEntity,userPojo.getBalance());
            modelAndView.setViewName("redirect:/mine.do?id="+userPojo.getId());
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main.do");
        return modelAndView;
    }

    //取钱
    @RequestMapping("transferOut.do")
    public ModelAndView transferOut(UserPojo userPojo){
        ModelAndView modelAndView = new ModelAndView();
        if(userPojo != null){
            UserEntity userEntity = new UserEntity();
            userEntity.setId(userPojo.getId());
            this.transferService.drawMoney(userEntity,userPojo.getBalance());
            modelAndView.setViewName("redirect:/mine.do?id="+userPojo.getId());
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main.do");
        return modelAndView;
    }

    //根据id查看全部转账信息
    @RequestMapping("transferInfo.do")
    public ModelAndView transferInfo(@RequestParam("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        if(id != null){
            ArrayList<TransferInfoEntity> list = (ArrayList<TransferInfoEntity>) this.transferService.getTransferById(Long.valueOf(id));
            modelAndView.addObject("transferInfo",list);
            modelAndView.setViewName("transferInfo");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main.do");
        return modelAndView;
    }

    //继承
    @RequestMapping("inherit.do")
    private ModelAndView inherit(@RequestParam("id") String id ,@SessionAttribute("loginUser") UserEntity loginUser){
        ModelAndView modelAndView = new ModelAndView();
        UserEntity father = null;
        UserEntity son = null;
        if(id != null && loginUser != null){
            father = this.userService.getById(Long.valueOf(id));
            son = this.userService.getById(loginUser.getId());
            this.transferService.inherit(father,son);
            modelAndView.setViewName("redirect:details.do?id="+ loginUser.getId());
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main");
        return modelAndView;
    }
}
