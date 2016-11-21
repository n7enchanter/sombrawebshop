package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.model.User;

import java.util.List;

/**
 * Created by Yuri on 03.11.2016.
 */
public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User findById(int id);
    User findByName(String username_email);
    List<User> getAll();
}
