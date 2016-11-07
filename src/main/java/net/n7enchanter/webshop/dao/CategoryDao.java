package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Category;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */
public interface CategoryDao {
    void sava_category(Category category);
    void update_category(Category category);
    void delete_category(int id);
    Category findById(int id);
    List<Category> findAll();
}
