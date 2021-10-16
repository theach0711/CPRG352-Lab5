/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import model.User;

/**
 *
 * @author 847240
 */
public class AccountService {
    public User login(String username,String password){
        if((username.equals("abe") || username.equals("barb")) && password.equals("password")){
            return new User(username, null);
        }
        return null;
}
}
