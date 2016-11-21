package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.model.Category;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */
public interface CategoryService {
    void savaCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category findById(int id);
    List<Category> findAll();
}
