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
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public void saveProduct(Product product) {
        getSessionFactory().getCurrentSession().persist(product);
    }
    @Transactional
    public void deleteProduct(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Product product = getSessionFactory().getCurrentSession().get(Product.class,new Integer(id));
        if(product != null){
            session.delete(product);

        }

    }
    @Transactional
    public void updateProduct(Product product) {
        getSessionFactory().getCurrentSession().update(product);

    }
    @Transactional
    public Product findById(int id) {
        Product product = getSessionFactory().getCurrentSession().get(Product.class,new Integer(id));
        return product;

    }
    @Transactional
    public List<Product> findAll() {
        List<Product> products = getSessionFactory().getCurrentSession().createCriteria(Product.class).list();
        return products;
    }

    public List<Product> searchQuery(String query) {
        List<Product> products = getSessionFactory().getCurrentSession().createCriteria(Product.class).add(Restrictions.like("product_name",query)).list();
        return products;
    }
}
