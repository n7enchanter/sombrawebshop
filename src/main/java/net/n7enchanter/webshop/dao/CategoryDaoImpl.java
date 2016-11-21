package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Category;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{
    @Autowired
    private  SessionFactory sessionFactory;
    

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void savaCategory(Category category) {
        getSessionFactory().getCurrentSession().persist(category);
    }

    public void updateCategory(Category category) {
        getSessionFactory().getCurrentSession().update(category);
    }

    public void deleteCategory(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Category category = session.get(Category.class,new Integer(id));
        if(category!=null){
            session.delete(category);
        }
    }

    public Category findById(int id) {
        Category category = getSessionFactory().getCurrentSession().get(Category.class,new Integer(id));
        return category;
    }

    public List<Category> findAll() {
        List<Category> categories = getSessionFactory().getCurrentSession().createCriteria(Category.class).list();
        return categories;
    }
}
