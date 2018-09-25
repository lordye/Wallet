package com.wzh.demo.service;

import com.wzh.demo.entity.TransferInfoEntity;
import com.wzh.demo.entity.UserEntity;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface TransferService {

    /**
     * 新增流水
     * @param in
     * @param out
     * @param balance
     */
    void addTransfer(UserEntity in, UserEntity out, double balance);

    /**
     * 查询流水
     * @param id
     * @return
     */
    List<TransferInfoEntity> getTransferById(long id);

    /**
     * 转账
     * @param in
     * @param out
     * @param balance
     * @return
     */
    boolean transfer(UserEntity in ,UserEntity out,double balance);

    /**
     * 继承用户
     * @param father
     * @param son
     */
    void inherit(UserEntity father,UserEntity son);

    /**
     * 存钱
     * @param userEntity
     * @param money
     */
    void saveMoney(UserEntity userEntity,double money);

    /**
     * 取钱
     * @param userEntity
     * @param money
     */
    void drawMoney(UserEntity userEntity, double money);

}
