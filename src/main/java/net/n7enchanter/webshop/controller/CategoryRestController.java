package net.n7enchanter.webshop.controller;

import net.n7enchanter.webshop.model.Category;
import net.n7enchanter.webshop.model.Product;
import net.n7enchanter.webshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuri on 30.10.2016.
 */
@RestController
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
/*

    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.GET )
    public  List<Category> getCategory(){
        return categoryService.findAll();
    }
*/
}
