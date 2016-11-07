package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.model.Basket;

/**
 * Created by Yuri on 06.11.2016.
 */
public interface BasketService {
    void save_basket(Basket basket);
    void update_basket(Basket basket);
    Basket getBasket(String username);
}
