package net.n7enchanter.webshop.controller;

import net.n7enchanter.webshop.model.Product;
import net.n7enchanter.webshop.service.BasketService;
import net.n7enchanter.webshop.service.CategoryService;
import net.n7enchanter.webshop.service.ProductService;
import net.n7enchanter.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Yuri on 05.11.2016.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private BasketService basketService;
    @RequestMapping("/product/{id}")
    public String productDetails(@PathVariable("id") int id, Model model){
        model.addAttribute("product",  productService.findById(id));

        return "productDetails";
    }
    @RequestMapping(value = "/admin" , method = RequestMethod.GET)
    public String productForm(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("users",userService.getAll());


        return "admin";
    }
    @RequestMapping(value = "/admin/delete/{id}")
    public String removeProduct(@PathVariable("id") int id){
        productService.delete_product(id);
        return "redirect:/product";
    }
    @RequestMapping(value = "/admin/edit/{id}")
    public String editProduct(@PathVariable("id") int id,Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("users",userService.getAll());
        return "/admin" ;

    }
    @RequestMapping(value = "/product?search={search}",method = RequestMethod.GET)
    public String search(@PathVariable("search") String search,Model model){
        model.addAttribute(productService.searchQuery(search));
        return "product";

    }
    @RequestMapping(value = "/admin/product/add")
    public String addProduct(@ModelAttribute("product")Product product){
        int id = product.getId();
        if(id == 0){
            productService.save_product(product);
            return "redirect:/product";
        }else {
            productService.update_product(product);
            return "redirect:/product/"+id;
        }


    }

    @RequestMapping(value = {"/","/product"}, method = RequestMethod.GET)
    public String start(Model model){

        model.addAttribute("products",productService.findAll());
        return "product";
    }
}
