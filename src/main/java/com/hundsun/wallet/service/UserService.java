package com.hundsun.wallet.service;

import com.hundsun.wallet.entity.UserEntity;

public interface UserService {

    /**
     * 用户注册
     * @param userEntity
     */
    void register(UserEntity userEntity);

    /**
     * 用户登录
     * @param userEntity
     */
    boolean login(UserEntity userEntity);

    /**
     * 更新用户信息
     * @param userEntity
     */
    void update(UserEntity userEntity);

    /**
     * 用户注销
     * @param userEntity
     */
    void remove(UserEntity userEntity);

    /**
     * 用户退出
     * @param userEntity
     */
    void exit(UserEntity userEntity);
}
