package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.dao.BasketDao;
import net.n7enchanter.webshop.dao.BasketDaoImpl;
import net.n7enchanter.webshop.model.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yuri on 06.11.2016.
 */
@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketDao basketDao;

    public BasketDao getBasketDao() {
        return basketDao;
    }

    public void setBasketDao(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    public void save_basket(Basket basket) {
        basketDao.save_basket(basket);

    }

    public void update_basket(Basket basket) {
        basketDao.update_basket(basket);
    }

    public Basket getBasket(String username) {
        return basketDao.getBasket(username);
    }
}


