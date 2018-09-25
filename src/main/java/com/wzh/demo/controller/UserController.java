package com.wzh.demo.controller;

import com.wzh.demo.POJO.UserPojo;
import com.wzh.demo.entity.UserEntity;
import com.wzh.demo.entity.WalletEntity;
import com.wzh.demo.service.TransferService;
import com.wzh.demo.service.UserService;
import com.wzh.demo.utils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;

@Controller
@RequestMapping("/user" )
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private TransferService transferService;


    /**
     * 登录之后跳转主页面
     * @return
     */
    // TODO 去掉密码字段，不传前台
    @RequestMapping(value = "main.do",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView("main");
        ArrayList<UserEntity> list = (ArrayList<UserEntity>) this.userService.getAll();
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    /**
     * 展示详情
     * @param detailsUserPojo
     * @return
     */
    @RequestMapping("details.do")
    public ModelAndView getDetails(UserPojo detailsUserPojo){
        ModelAndView modelAndView = new ModelAndView();
//        UserPojo userPojo = new UserPojo();
//        UserEntity userEntity = null;
//        if(detailsUserPojo != null){
//            userEntity = this.userService.getById(detailsUserPojo.getId());
//            WalletEntity walletEntity = this.userService.getWallet(userEntity.getWalletId());
//            try {
//                if(userEntity.getPassword().equals(MD5Utils.convertMD5(detailsUserPojo.getPassword()))) {
//                    modelAndView.setViewName("details");
//                    userPojo.setId(userEntity.getId());
//                    userPojo.setUsername(userEntity.getUsername());
//                    userPojo.setPassword(userEntity.getPassword());
//                    userPojo.setBalance(walletEntity.getBalance());
//                    modelAndView.addObject("detailsUser", userPojo);
//                    return modelAndView;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        modelAndView.setViewName("redirect:main.do");
        return  modelAndView;
    }

    //显示个人信息
    @RequestMapping("mine.do")
    public ModelAndView mine(@RequestParam("id" ) String id){
        ModelAndView modelAndView = new ModelAndView();
        UserPojo userPojo = new UserPojo();
        if(id != null){
            UserEntity userEntity = this.userService.getById(Long.valueOf(id));
            WalletEntity walletEntity = this.userService.getWallet(Long.valueOf(userEntity.getWalletId()));
            userPojo.setId(userEntity.getId());
            userPojo.setUsername(userEntity.getUsername());
            userPojo.setPassword(userEntity.getPassword());
            userPojo.setBalance(walletEntity.getBalance());
            modelAndView.setViewName("details");
            modelAndView.addObject("detailsUser",userPojo);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main.do");
        return  modelAndView;
    }




    //删除用户
    @RequestMapping("remove.do")
    public ModelAndView remove(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity userEntity = new UserEntity();
        if (id != null) {
            userEntity = this.userService.getById(Long.valueOf(id));
            this.userService.remove(userEntity);
            modelAndView.setViewName("redirect:main.do");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main.do");
        return modelAndView;
    }

    //退出登录
    @RequestMapping("signOut.do")
    public ModelAndView  signOut(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("redirect:index.do");
        Enumeration<String> em = request.getSession().getAttributeNames();
        while (em.hasMoreElements()) {
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        request.getSession().invalidate();
        return modelAndView;
    }

    //密码验证
    @RequestMapping("checkPassword.do")
    public ModelAndView checkPassword(@RequestParam("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        UserEntity userEntity = null;
        if(id != null){
            userEntity = this.userService.getById(Long.valueOf(id));
            UserPojo userPojo = new UserPojo();
            userPojo.setId(userEntity.getId());
            userPojo.setUsername(userEntity.getUsername());
            modelAndView.addObject("detailsUser",userPojo);
            modelAndView.setViewName("checkPassword");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:main.do");
        return modelAndView;
    }



    public UserService getUserService() { return userService; }
    public void setUserService(UserService userService) { this.userService = userService; }
    public TransferService getTransferService() { return transferService; }
    public void setTransferService(TransferService transferService) { this.transferService = transferService; }
}
