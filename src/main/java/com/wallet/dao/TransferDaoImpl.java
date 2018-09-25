package com.wzh.demo.dao;

import com.wzh.demo.entity.TransferInfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class TransferDaoImpl implements TransferDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void add(TransferInfoEntity transferInfoEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(transferInfoEntity);
    }

    public List<TransferInfoEntity> getById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from TransferInfoEntity where userIn =:inId or userOut =:outId");
        query.setParameter("inId",id);
        query.setParameter("outId",id);
        List<TransferInfoEntity> list = query.list();
        return list;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
