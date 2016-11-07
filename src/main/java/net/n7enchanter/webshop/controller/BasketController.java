package net.n7enchanter.webshop.controller;

import net.n7enchanter.webshop.model.Basket;
import net.n7enchanter.webshop.model.Product;
import net.n7enchanter.webshop.model.User;
import net.n7enchanter.webshop.service.BasketService;
import net.n7enchanter.webshop.service.ProductService;
import net.n7enchanter.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Yuri on 06.11.2016.
 */
@Controller
public class BasketController {
    @Autowired
    private UserService userService;
    @Autowired
    private BasketService basketService;
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/basket" ,method = RequestMethod.GET)

    private String getBasket(Model model){
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = basketService.getBasket(username);
        if(basket==null){
            basket = new Basket();
            basket.setName(username);
            basketService.save_basket(basket);
            basket = basketService.getBasket(username);

        }

        List<Product> products = basket.getProducts();
        int items = products.size();
        model.addAttribute("products",products);
        model.addAttribute("items",items);

        return "basket";
    }
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    private String buyproduct(@PathVariable("id") int id, @ModelAttribute("product") Product product){
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = basketService.getBasket(username);
        if(basket==null){
            basket = new Basket();
            basket.setName(username);
            basketService.save_basket(basket);
            basket = basketService.getBasket(username);
        }
        List<Product> products = basket.getProducts();
        products.add(product);
        basket.setProducts(products);
        if(basketService.getBasket(username)==null){
            basketService.save_basket(basket);

        }
        else{
        basketService.update_basket(basket);
        }
        return "redirect:/product";

    }
    @RequestMapping(value = "/basket/purchase")
    public String purchase(){
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = basketService.getBasket(username);
        basket.getProducts().clear();
        basketService.update_basket(basket);
        return "redirect:/product";
    }
    @RequestMapping(value = "/basket/remove")
    public String clearBasket(){
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = basketService.getBasket(username);
        basket.getProducts().clear();
        basketService.update_basket(basket);
        return "redirect:/product";
    }

    @RequestMapping(value = "/basket/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
        String username =  SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = basketService.getBasket(username);
        Product product = productService.findById(id);
        List<Product> products = basket.getProducts();
        //products.remove(product);
        int index = products.indexOf(product);
        products.remove(index+1);
        basket.setProducts(products);
        basketService.update_basket(basket);
        return "redirect:/basket";
    }
}
