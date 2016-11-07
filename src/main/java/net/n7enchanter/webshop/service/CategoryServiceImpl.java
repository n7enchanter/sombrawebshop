package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.dao.CategoryDao;
import net.n7enchanter.webshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yuri on 29.10.2016.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void sava_category(Category category) {
        categoryDao.sava_category(category);
    }

    public void update_category(Category category) {
        categoryDao.update_category(category);
    }

    public void delete_category(int id) {
        categoryDao.delete_category(id);
    }

    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
