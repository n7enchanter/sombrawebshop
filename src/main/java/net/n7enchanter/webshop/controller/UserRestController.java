package net.n7enchanter.webshop.controller;

import net.n7enchanter.webshop.model.User;
import net.n7enchanter.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Yuri on 05.11.2016.
 */
@RestController
public class UserRestController {
    @Autowired
    private UserService userService;
    /*
    @RequestMapping(value = "/admin/userred",method = RequestMethod.GET)
    public List<User> userred(){
        List<User> users=userService.getAll();
        return users;
    }
    */
}
