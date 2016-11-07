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

    public void save_user(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleDao.findByid(1));
        user.setRoles(roles);
        userDao.save_user(user);

    }

    public void update_user(User user) {

        userDao.update_user(user);
    }

    public void delete_user(int id) {
        userDao.delete_user(id);

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
