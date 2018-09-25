package com.wzh.demo.dao;

import com.wzh.demo.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userEntity);
    }

    public void update(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userEntity);
    }

    public void remove(UserEntity userEntity) {
        userEntity.setFlag("3");
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userEntity);
    }



    public void freeze(UserEntity userEntity) {
        userEntity.setFlag("2");
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userEntity);
    }

    public UserEntity getById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity userEntity = session.load(UserEntity.class,id);
        return userEntity;
    }

    public UserEntity getByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserEntity where username =:name");
        UserEntity userEntity = (UserEntity) query.setParameter("name",name).uniqueResult();
        return userEntity;
    }

    public List<UserEntity> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserEntity where flag =:flag");
        query.setParameter("flag","1");
        List<UserEntity> list =  query.list();
        return list;
    }
}
