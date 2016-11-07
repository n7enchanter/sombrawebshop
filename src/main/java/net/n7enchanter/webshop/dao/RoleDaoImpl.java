package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Role;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuri on 03.11.2016.
 */
@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save_role(Role role) {
        getSessionFactory().getCurrentSession().persist(role);

    }

    public Role findByid(int id) {
        return getSessionFactory().getCurrentSession().get(Role.class,new Integer(id));
    }

    public List<Role> getAll() {
        return (List<Role>) getSessionFactory().getCurrentSession().createCriteria(Role.class).list();
    }
}
