package net.n7enchanter.webshop.service;


import net.n7enchanter.webshop.model.Product;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */
public interface ProductService {
    void save_product(Product product);
    void delete_product(int id);
    void update_product(Product product);
    Product findById(int id);
    List<Product> findAll();
    List<Product> searchQuery(String query);


}
