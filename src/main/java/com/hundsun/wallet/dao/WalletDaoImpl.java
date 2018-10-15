package com.hundsun.wallet.dao;

import com.hundsun.wallet.entity.WalletEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.util.List;

public class WalletDaoImpl implements WalletDao {

    @Resource
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 新增钱包
     *
     * @param walletEntity
     */
    @Override
    public void add(WalletEntity walletEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(walletEntity);
    }

    /**
     * 通过拥有者姓名获取钱包
     *
     * @param OwnerName
     * @return
     */
    @Override
    public WalletEntity getByOwnerName(String OwnerName) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from WalletEntity where ownerName = :OwnerName");
        query.setParameter("OwnerName",OwnerName);
        List list = query.list();
        if (list.size() > 0){
            return (WalletEntity)list.get(0);
        }else {
            return null;
        }
    }
}
