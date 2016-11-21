package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.model.Basket;
import net.n7enchanter.webshop.model.Product;

import java.util.List;

/**
 * Created by Yuri on 06.11.2016.
 */
public interface BasketService {
    void saveBasket(Basket basket);
    void updateBasket(Basket basket);
    Basket getBasket(String username);
    void deleteAllProducts();
    List<Product> getProducts();
    void buyProduct (Product product);
    void deleteProduct(int id);
}
