package com.hundsun.wallet.dao;

import com.hundsun.wallet.entity.UserInfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.annotation.Resource;
import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {

    @Resource
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 新增用户信息
     *
     * @param userInfoEntity
     */
    @Override
    public void add(UserInfoEntity userInfoEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(userInfoEntity);
    }

    /**
     * 通过用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfoEntity getByUserNmae(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserInfoEntity where username = :userName");
        query.setParameter("userName",userName);
        List list = query.list();
        if (list.size() > 0){
            return (UserInfoEntity)list.get(0);
        }else {
            return null;
        }

    }
}
