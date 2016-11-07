package net.n7enchanter.webshop.controller;

import net.n7enchanter.webshop.model.Product;
import net.n7enchanter.webshop.service.CategoryService;
import net.n7enchanter.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuri on 30.10.2016.
 */

@RestController
public class ProductRestController {


    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    /*@RequestMapping(value = "/products" , method = RequestMethod.GET )
    public List<Product> getAll (){
        List<Product> products=productService.findAll();
        return products;

    }*/
/*
    @RequestMapping(value = "/products?searchQuery={query}",method=RequestMethod.GET)
    public  List<Product> getByQuery(@PathVariable("query") String query){
        List<Product> products = productService.searchQuery(query);
        return products;
    }
    @RequestMapping(value = "/productrest/{id}" , method = RequestMethod.GET )
    public  Product getById(@PathVariable("id") String id) {
        Product product = productService.findById(Integer.parseInt(id));
        return product;
    }

    @RequestMapping(value = "/products?category={c_id}" , method = RequestMethod.GET )
    public  List<Product> getByCategory (@PathVariable("c_id") int c_id ){

        List<Product> products = categoryService.findById(c_id).getProducts();
        return products;
    }*/


}



