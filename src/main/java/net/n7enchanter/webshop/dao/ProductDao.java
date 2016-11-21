package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Product;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */

public interface ProductDao {
    void saveProduct(Product product);
    void deleteProduct(int id);
    void updateProduct(Product product);
    Product findById(int id);
    List<Product> findAll();
    List<Product> searchQuery(String query);


}
