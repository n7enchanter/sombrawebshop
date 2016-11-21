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
        List<Product> products =basketService.getProducts();
        model.addAttribute("products",products);
        model.addAttribute("items",products.size());

        return "basket";
    }
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.PUT)
    private String buyProduct(@PathVariable("id") int id, @ModelAttribute("product") Product product){
       basketService.buyProduct(product);
        return "redirect:/product";

    }
    @RequestMapping(value = "/basket/purchase", method = RequestMethod.DELETE)
    public String purchase(){
       basketService.deleteAllProducts();
        return "redirect:/product";
    }
    @RequestMapping(value = "/basket/remove" , method = RequestMethod.DELETE)
    public String clearBasket(){
        basketService.deleteAllProducts();
        return "redirect:/product";
    }

    @RequestMapping(value = "/basket/remove/{id}" , method = RequestMethod.DELETE)
    public String removeProduct(@PathVariable("id") int id){
        basketService.deleteProduct(id);
        return "redirect:/basket";
    }
}
