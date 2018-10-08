package com.hundsun.wallet.dao;

import com.hundsun.wallet.entity.UserEntity;

/**
 * 用户操作
 */
public interface UserDao {
    /**
     * 新增用户
     * @param userEntity
     */
    void add(UserEntity userEntity);

    /**
     * 修改用户
     * @param userEntity
     */
    void update(UserEntity userEntity);

    /**
     * 删除用户
     * @param userEntity
     */
    void remove(UserEntity userEntity);

    /**
     * 冻结用户
     * @param userEntity
     */
    void freeze(UserEntity userEntity);

    /**
     * 通过ID获取用户
     * @param userId
     */
    UserEntity getById(long userId);

    /**
     * 通过用户名获取用户
     * @param userName
     */
    UserEntity getByName(String userName);
}
