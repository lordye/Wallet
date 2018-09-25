package com.wzh.demo.service;

import com.wzh.demo.dao.UserDao;
import com.wzh.demo.dao.WalletDao;
import com.wzh.demo.entity.TransferInfoEntity;
import com.wzh.demo.entity.UserEntity;
import com.wzh.demo.entity.WalletEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.wzh.demo.dao.TransferDao;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Resource
    private TransferDao transferDao;

    @Resource
    private UserDao userDao;
    @Resource
    private WalletDao walletDao;

    @Transactional
    public void addTransfer(UserEntity in,UserEntity out,double balance) {
        TransferInfoEntity transferInfoEntity = new TransferInfoEntity(in.getId(),out.getId());
        transferInfoEntity.setUserIn(in.getId());
        transferInfoEntity.setUserInName(in.getUsername());
        transferInfoEntity.setUserOut(out.getId());
        transferInfoEntity.setUserOutName(out.getUsername());
        transferInfoEntity.setBalance(balance);
        this.transferDao.add(transferInfoEntity);
    }

    @Transactional(readOnly = true)
    public List<TransferInfoEntity> getTransferById(long id) {
        return this.transferDao.getById(id);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveMoney(UserEntity userEntity, double money) {
        //一般从网页获取的值只包含id，所以这里先通过id获取用户信息，尤其是钱包id
        userEntity = this.userDao.getById(userEntity.getId());
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setId(userEntity.getWalletId());
        walletEntity.setBalance(money);
        this.walletDao.transferIn(walletEntity);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void drawMoney(UserEntity userEntity, double money) {
        //一般从网页获取的值只包含id，所以这里先通过id获取用户信息，尤其是钱包id
        userEntity = this.userDao.getById(userEntity.getId());
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setId(userEntity.getWalletId());
        walletEntity.setBalance(money);
        this.walletDao.transferOut(walletEntity);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE )
    public boolean transfer(UserEntity in, UserEntity out, double balance) {
        out = this.userDao.getById(out.getId());
        WalletEntity walletOut = new WalletEntity();
        walletOut.setId(out.getWalletId());
        walletOut.setBalance(balance);
        if(this.walletDao.transferOut(walletOut)){
            in = this.userDao.getById(in.getId());
            WalletEntity walletIn = new WalletEntity();
            walletIn.setId(in.getWalletId());
            walletIn.setBalance(balance);
            this.walletDao.transferIn(walletIn);
            return true;
        }
        return false;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void inherit(UserEntity father, UserEntity son) {
        father= this.userDao.getById(father.getId());////一般从网页获取的值只包含id，所以这里先通过id获取用户信息，尤其是钱包id
        WalletEntity walletEntity = this.walletDao.findById(father.getWalletId());//获取被继承钱包信息
        this.transfer(son,father,walletEntity.getBalance());//执行转账操作，将被继承账户余额转入继承账户
        this.userDao.freeze(father);//冻结被继承用户
        this.walletDao.freeze(walletEntity);//冻结被继承钱包
    }




    public TransferDao getTransferDao() {
        return transferDao;
    }

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
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
}
