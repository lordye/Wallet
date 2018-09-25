package com.wzh.demo.test;

import com.wzh.demo.entity.UserEntity;
import com.wzh.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test extends ApplicationObjectSupport {

    public void test()
    {
        ApplicationContext applicationContext = this.getApplicationContext();
        UserService userService = (UserService) applicationContext.getBean("userService");
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        userEntity.setUsername("admin");
        userService.add(userEntity);
    }

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:/apps/IntelliJ IDEA/workspaces/demo/src/main/webapp/WEB-INF/applicationContext.xml");
//        UserService userService = (UserService) applicationContext.getBean("userService");
//        UserEntity userEntity = new UserEntity();
//        UserEntity userEntity1 = new UserEntity();
//        userEntity.setUsername("admin");
//        userEntity.setPassword("admin");
//        userEntity.setId(4);
//        userEntity1.setId(5);
//        userService.add(userEntity);
//        userService.saveMoney(userEntity,100);
//        userService.drawMoney(userEntity,30);
//        userService.transfer(userEntity1,userEntity,50);
//        userService.inherit(userEntity,userEntity1);
//        ArrayList<UserEntity> list = (ArrayList<UserEntity>) userService.getAll();
//        for (UserEntity u: list) {
//            System.out.println(u.getId());
//        }

//        Date now = new Date();
//        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
//        String str = sf.format(now);
//        System.out.println(str);

        System.out.println(new Date().getTime());


    }
}
