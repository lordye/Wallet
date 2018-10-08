package com.hundsun.wallet.service;

import com.hundsun.wallet.dao.UserDao;
import com.hundsun.wallet.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 用户注册
     *
     * @param userEntity
     */
    @Transactional
    public void register(UserEntity userEntity) {

    }

    /**
     * 用户登录
     *
     * @param userEntity
     */
    @Transactional
    public boolean login(UserEntity userEntity) {
        UserEntity user = this.userDao.getByName(userEntity.getUsername());
        if (user != null){
            System.out.println(user.getPassword());
            System.out.println(user.getPassword());
            if (user.getPassword().equals(userEntity.getPassword())){
                return true;
            }
        }
        return false;
    }

    /**
     * 更新用户信息
     *
     * @param userEntity
     */
    @Transactional
    public void update(UserEntity userEntity) {

    }

    /**
     * 用户注销
     *
     * @param userEntity
     */
    @Transactional
    public void remove(UserEntity userEntity) {

    }

    /**
     * 用户退出
     *
     * @param userEntity
     */
    @Transactional
    public void exit(UserEntity userEntity) {

    }
}
