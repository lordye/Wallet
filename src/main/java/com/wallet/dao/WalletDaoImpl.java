package com.wzh.demo.dao;

import com.wzh.demo.entity.WalletEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WalletDaoImpl implements WalletDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public long add() {
        WalletEntity walletEntity = new WalletEntity();
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(walletEntity);
        return walletEntity.getId();
    }

    public void transferIn(WalletEntity walletEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        WalletEntity wallet = session.load(WalletEntity.class,walletEntity.getId());
        double balance = wallet.getBalance() + walletEntity.getBalance();
        wallet.setBalance(balance);
    }

    public boolean transferOut(WalletEntity walletEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        WalletEntity wallet = session.load(WalletEntity.class,walletEntity.getId());
        if(wallet.getBalance() < walletEntity.getBalance())//转账余额不够
            return false;
        else
            wallet.setBalance(wallet.getBalance() - walletEntity.getBalance());
        return true;
    }

    public void freeze(WalletEntity walletEntity) {
        walletEntity.setFlag("2");
        Session session = this.sessionFactory.getCurrentSession();
        session.update(walletEntity);
    }

    public WalletEntity findById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        WalletEntity walletEntity = session.load(WalletEntity.class,id);
        return walletEntity;
    }
}
