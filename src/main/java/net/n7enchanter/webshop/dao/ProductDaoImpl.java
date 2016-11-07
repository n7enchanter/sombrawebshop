package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Category;
import net.n7enchanter.webshop.model.Product;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save_product(Product product) {
        getSessionFactory().getCurrentSession().persist(product);
    }

    public void delete_product(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Product product = getSessionFactory().getCurrentSession().get(Product.class,new Integer(id));
        if(product != null){
            session.delete(product);

        }

    }

    public void update_product(Product product) {
        getSessionFactory().getCurrentSession().update(product);

    }

    public Product findById(int id) {
        Product product = getSessionFactory().getCurrentSession().get(Product.class,new Integer(id));
        return product;

    }

    public List<Product> findAll() {
        List<Product> products = getSessionFactory().getCurrentSession().createCriteria(Product.class).list();
        return products;
    }

    public List<Product> searchQuery(String query) {
        List<Product> products = getSessionFactory().getCurrentSession().createCriteria(Product.class).add(Restrictions.like("product_name",query)).list();
        return products;
    }
}
