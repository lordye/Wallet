package com.wzh.demo.dao;

import java.util.List;
import com.wzh.demo.entity.UserEntity;

/**
 * 用户相关操作
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
     * 通过id获取用户信息
     * @param id
     * @return
     */
    UserEntity getById(long id);

    /**
     * 通过用户名获取用户信息
     * @param name
     * @return
     */
    UserEntity getByName(String name);

    /**
     * 返回所有用户
     * @return
     */
    List<UserEntity> getAll();
}
