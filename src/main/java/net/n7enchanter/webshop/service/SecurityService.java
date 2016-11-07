package net.n7enchanter.webshop.service;

/**
 * Created by Yuri on 03.11.2016.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
