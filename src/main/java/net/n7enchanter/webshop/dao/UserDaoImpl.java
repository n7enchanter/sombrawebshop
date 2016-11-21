package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuri on 03.11.2016.
 */
@Repository

public class UserDaoImpl implements UserDao{
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public void saveUser(User user) {
        getSessionFactory().getCurrentSession().persist(user);
    }

    public void updateUser(User user) {
        getSessionFactory().getCurrentSession().update(user);

    }

    public void deleteUser(int id) {
        Session session = getSessionFactory().getCurrentSession();
        User user = getSessionFactory().getCurrentSession().get(User.class,new Integer(id));
        if(user != null){
            session.delete(user);

        }

    }


    public User findById(int id) {
        User user = getSessionFactory().getCurrentSession().get(User.class,new Integer(id));
        return  user;
    }

    public User findByName(String username) {
        Session session = getSessionFactory().getCurrentSession();
        User user = (User) session.createCriteria(User.class).add(Restrictions.eq("username",username)).uniqueResult();
        if (user != null) {
            return user;
        }
        else{
            return null;
        }
    }
    @Transactional
    public List<User> getAll() {
            return (List<User>) getSessionFactory().getCurrentSession().createCriteria(User.class).list();
    }
}

