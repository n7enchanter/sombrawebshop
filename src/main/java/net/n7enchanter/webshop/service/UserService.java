package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.model.User;

import java.util.List;

/**
 * Created by Yuri on 03.11.2016.
 */
public interface UserService {
    void save_user(User user);
    void update_user(User user);
    void delete_user(int id);
    User findById(int id);
    User findByName(String username_email);
    List<User> getAll();
}
