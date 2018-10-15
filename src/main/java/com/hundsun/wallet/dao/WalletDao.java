package com.hundsun.wallet.dao;

import com.hundsun.wallet.entity.WalletEntity;

public interface WalletDao {
    /**
     * 新增钱包
     * @param walletEntity
     */
    void add(WalletEntity walletEntity);

    /**
     * 通过拥有者姓名获取钱包
     * @param OwnerName
     * @return
     */
    WalletEntity getByOwnerName(String OwnerName);
}
