package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.dao.BasketDao;
import net.n7enchanter.webshop.dao.BasketDaoImpl;
import net.n7enchanter.webshop.dao.ProductDao;
import net.n7enchanter.webshop.model.Basket;
import net.n7enchanter.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuri on 06.11.2016.
 */
@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    private BasketDao basketDao;
    @Autowired
    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public BasketDao getBasketDao() {
        return basketDao;
    }

    public void setBasketDao(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    public void saveBasket(Basket basket) {
        basketDao.saveBasket(basket);

    }

    public void updateBasket(Basket basket) {
        basketDao.updateBasket(basket);
    }

    public Basket getBasket(String username) {
        return basketDao.getBasket(username);
    }

    public void deleteAllProducts() {
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = basketDao.getBasket(username);
        basket.getProducts().clear();
        this.updateBasket(basket);

    }

    public List<Product> getProducts() {
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = this.getBasket(username);
        if(basket==null){
            basket = new Basket();
            basket.setName(username);
            this.saveBasket(basket);
            basket = this.getBasket(username);

        }
        List<Product> products = basket.getProducts();
        return products;
    }

    public void buyProduct(Product product) {
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = this.getBasket(username);
        if(basket==null){
            basket = new Basket();
            basket.setName(username);
            this.saveBasket(basket);
            basket = this.getBasket(username);
        }
        List<Product> products = basket.getProducts();
        products.add(product);
        basket.setProducts(products);
        if(this.getBasket(username)==null){
            this.saveBasket(basket);

        }
        else{
            this.updateBasket(basket);
        }
    }

    public void deleteProduct(int id) {
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = this.getBasket(username);
        Product product = productDao.findById(id);
        List<Product> products = basket.getProducts();
        //products.remove(product);
        int index = products.indexOf(product);
        products.remove(index+1);
        basket.setProducts(products);
        this.updateBasket(basket);
    }
}


