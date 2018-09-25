package com.wzh.demo.service;

import com.sun.xml.internal.bind.v2.TODO;
import com.wzh.demo.POJO.UserPojo;
import com.wzh.demo.dao.TransferDao;
import com.wzh.demo.dao.UserDao;
import com.wzh.demo.dao.WalletDao;
import com.wzh.demo.entity.UserEntity;
import com.wzh.demo.entity.WalletEntity;
import com.wzh.demo.utils.MD5Utils;
import com.wzh.demo.utils.StautsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private WalletDao walletDao;
    @Resource
    private TransferDao transferDao;


    @Transactional
    public void add(UserEntity userEntity) {
        userEntity.setWalletId(this.walletDao.add());
        this.userDao.add(userEntity);
    }

    /**
     * 用户注册
     *
     * @param userPojo
     * @throws Exception
     * @return
     */
    @Transactional
    public String register(UserPojo userPojo) throws Exception {
        UserEntity userEntity = new UserEntity();
        if(this.userDao.getByName(userPojo.getUsername()) == null) {//如果没有同名的用户
            userEntity.setUsername(userPojo.getUsername());
            userEntity.setPassword(MD5Utils.convertMD5(userPojo.getPassword()));
            userEntity.setWalletId(this.walletDao.add());
            this.userDao.add(userEntity);
            return StautsUtils.OPERATION_SUCCESS;
        }
        return StautsUtils.OPERATION_FAILED_USERNAME;
    }

    /**
     * 用户登录
     *
     * @param userPojo
     * @param session
     * @return
     */
    @Transactional
    public String login(UserPojo userPojo , HttpSession session) throws Exception {
        UserEntity userEntity = this.userDao.getByName(userPojo.getUsername());
        if(userEntity != null){
            if(userEntity.getPassword().equals(MD5Utils.convertMD5(userPojo.getPassword()))){
                session.setAttribute("loginUser",userEntity);
                return StautsUtils.OPERATION_SUCCESS;
            }
            return StautsUtils.OPERATION_FAILED_PASSWORD;
        }
        return StautsUtils.OPERATION_NULL;
    }

    /**
     * 查询用户详细信息
     *
     * @param userPojo
     * @return
     */
    public UserPojo getOthersUserInfo(UserPojo userPojo) {
        return null;
    }

    @Transactional
    public void update(UserEntity userEntity) {
        this.userDao.update(userEntity);
    }


    @Transactional
    public void remove(UserEntity userEntity) {
        WalletEntity walletEntity = this.walletDao.findById(userEntity.getWalletId());
        if(walletEntity.getBalance() == 0) {
            this.userDao.remove(userEntity);
        }
    }





    @Transactional(readOnly = true)
    public UserEntity getById(long id) {
        return this.userDao.getById(id);
    }
    @Transactional(readOnly = true)
    public UserEntity getByName(String name) {
        return this.userDao.getByName(name);
    }

    @Transactional(readOnly = true)
    public WalletEntity getWallet(long id) {
        return this.walletDao.findById(id);
    }


    @Transactional(readOnly = true)
    public List<UserEntity> getAll() {
        return this.userDao.getAll();
    }







    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public WalletDao getWalletDao() {
        return walletDao;
    }

    public void setWalletDao(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    public TransferDao getTransferDao() {
        return transferDao;
    }

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }
}
