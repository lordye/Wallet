package com.hundsun.wallet.dao;

import com.hundsun.wallet.entity.UserInfoEntity;

public interface UserInfoDao {
    /**
     * 新增用户信息
     * @param userInfoEntity
     */
    void add(UserInfoEntity userInfoEntity);

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    UserInfoEntity getByUserNmae(String userName);
}
