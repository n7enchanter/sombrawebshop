package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Basket;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yuri on 06.11.2016.
 */
@Repository
@Transactional
public class BasketDaoImpl implements BasketDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save_basket(Basket basket) {
        getSessionFactory().getCurrentSession().persist(basket);
    }

    public void update_basket(Basket basket) {
        getSessionFactory().getCurrentSession().update(basket);
    }

    public Basket getBasket(String username) {
        Basket basket = (Basket)getSessionFactory().getCurrentSession().createCriteria(Basket.class).add(Restrictions.eq("name",username)).uniqueResult();
        return basket;
    }
}
