package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.dao.ProductDao;
import net.n7enchanter.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void save_product(Product product) {
        productDao.save_product(product);
    }

    public void delete_product(int id) {
        productDao.delete_product(id);
    }

    public void update_product(Product product) {
        productDao.update_product(product);
    }

    public Product findById(int id) {
        return productDao.findById(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }



    public List<Product> searchQuery(String query) {
        return productDao.searchQuery(query);
    }
}
