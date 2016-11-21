package net.n7enchanter.webshop.service;

import net.n7enchanter.webshop.dao.RoleDao;
import net.n7enchanter.webshop.dao.UserDao;
import net.n7enchanter.webshop.model.Role;
import net.n7enchanter.webshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuri on 03.11.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleDao.findById(1);
        user.setRole(role);
        userDao.saveUser(user);

    }

    public void updateUser(User user) {

        userDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);

    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public User findByName(String username) {
        return userDao.findByName(username);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
}
