package com.wzh.demo.service;

import com.wzh.demo.POJO.UserPojo;
import com.wzh.demo.entity.TransferInfoEntity;
import com.wzh.demo.entity.UserEntity;
import com.wzh.demo.entity.WalletEntity;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    /**
     * 新增用户
     * @param userEntity
     */
    void add(UserEntity userEntity);

    /**
     * 用户注册
     * @param userPojo
     * @return
     */
    String register(UserPojo userPojo) throws Exception;

    /**
     * 用户登录
     * @param userPojo
     * @param session
     * @return
     */
    String login(UserPojo userPojo , HttpSession session) throws Exception;

    /**
     * 查询用户详细信息
     * @param userPojo
     * @return
     */
    UserPojo getOthersUserInfo(UserPojo userPojo);

    /**
     *
     * @param userEntity
     */
    void update(UserEntity userEntity);

    /**
     * 删除用户
     * @param userEntity
     */
    void remove(UserEntity userEntity);

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
     * 通过id获取钱包信息
     * @param id
     * @return
     */
    WalletEntity getWallet(long id);

    /**
     * 获取所有激活状态用户信息
     * @return
     */
    List<UserEntity> getAll();

}
