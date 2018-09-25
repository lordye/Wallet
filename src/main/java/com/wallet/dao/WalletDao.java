package com.wzh.demo.dao;

import com.wzh.demo.entity.WalletEntity;

public interface WalletDao {
    /**
     * 新增钱包
     * @return
     */
    long add();

    /**
     * 转账转入
     * @param walletEntity
     */
    void transferIn(WalletEntity walletEntity);

    /**
     * 转账转出
     * @param walletEntity
     * @return
     */
    boolean transferOut(WalletEntity walletEntity);

    /**
     * 冻结钱包
     * @param walletEntity
     */
    void freeze(WalletEntity walletEntity);

    /**
     * 根据钱包id获取钱包信息
     * @param id
     * @return
     */
    WalletEntity findById(long id);
}
