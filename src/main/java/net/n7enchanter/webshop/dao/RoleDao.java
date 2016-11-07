package net.n7enchanter.webshop.dao;

import net.n7enchanter.webshop.model.Role;
import net.n7enchanter.webshop.model.User;

import java.util.List;

/**
 * Created by Yuri on 03.11.2016.
 */
public interface RoleDao {
    void save_role(Role role);
    Role findByid(int id);
    List<Role> getAll();
}
