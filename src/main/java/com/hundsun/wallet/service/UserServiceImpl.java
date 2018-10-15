package com.hundsun.wallet.service;

import com.hundsun.wallet.dao.UserDao;
import com.hundsun.wallet.dao.UserInfoDao;
import com.hundsun.wallet.dao.WalletDao;
import com.hundsun.wallet.entity.UserEntity;
import com.hundsun.wallet.entity.UserInfoEntity;
import com.hundsun.wallet.entity.WalletEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private UserInfoDao userInfoDao;
    @Resource
    private WalletDao walletDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public void setWalletDao(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    /**
     * 用户注册
     *
     * @param userEntity
     */
    @Transactional
    public boolean register(UserEntity userEntity, WalletEntity walletEntity, UserInfoEntity userInfoEntity) {
        walletEntity.setBalance(0);
        walletEntity.setFlag("1");
        walletEntity.setOwnerName(userEntity.getUsername());
        walletEntity.setReserve1("");
        walletEntity.setReserve2("");
        userInfoEntity.setCreditScore(500);
        userInfoEntity.setUsername(userEntity.getUsername());
        userInfoEntity.setPhoneNumber(userEntity.getReserve1());
        userInfoEntity.setEmail(userEntity.getReserve2());
        userInfoEntity.setReserve1("");
        userInfoEntity.setReserve2("");
        this.walletDao.add(walletEntity);
        this.userInfoDao.add(userInfoEntity);
        userEntity.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        userEntity.setFlag("1");
        userEntity.setWalletEntity(this.walletDao.getByOwnerName(userEntity.getUsername()));
        userEntity.setUserInfoEntity(this.userInfoDao.getByUserNmae(userEntity.getUsername()));
        userEntity.setReserve1("");
        userEntity.setReserve2("");
        this.userDao.add(userEntity);

        return true;
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
