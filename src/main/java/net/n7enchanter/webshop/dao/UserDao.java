package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.User;

import java.util.List;

/**
 * Created by Yuri on 03.11.2016.
 */
public interface UserDao {
    void save_user(User user);
    void update_user(User user);
    void delete_user(int id);
    User findById(int id);
    User findByName(String username);
    List<User> getAll();
}
