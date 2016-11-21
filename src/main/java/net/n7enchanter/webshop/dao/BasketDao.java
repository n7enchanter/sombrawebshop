package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Basket;

/**
 * Created by Yuri on 06.11.2016.
 */
public interface BasketDao {
    void saveBasket(Basket basket);
    void updateBasket(Basket basket);
    Basket getBasket(String username);

}
