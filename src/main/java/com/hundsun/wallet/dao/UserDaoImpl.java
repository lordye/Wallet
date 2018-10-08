package com.hundsun.wallet.dao;

import com.hundsun.wallet.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Resource
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 新增用户
     *
     * @param userEntity
     */
    @Override
    public void add(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userEntity);
    }

    /**
     * 修改用户
     *
     * @param userEntity
     */
    @Override
    public void update(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userEntity);
    }

    /**
     * 删除用户
     *
     * @param userEntity
     */
    @Override
    public void remove(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(userEntity);
    }

    /**
     * 冻结用户
     *
     * @param userEntity
     */
    @Override
    public void freeze(UserEntity userEntity) {

    }

    /**
     * 通过ID获取用户
     *
     * @param userId
     */
    @Override
    public UserEntity getById(long userId) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity userEntity = session.load(UserEntity.class,userId);
        return userEntity;
    }

    /**
     * 通过用户名获取用户
     *
     * @param userName
     */
    @Override
    public UserEntity getByName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserEntity where username = :userName");
        query.setParameter("userName",userName);
        List list = query.list();
        if (list.size() > 0){
            return (UserEntity)list.get(0);
        }else {
            return null;
        }
    }

}
