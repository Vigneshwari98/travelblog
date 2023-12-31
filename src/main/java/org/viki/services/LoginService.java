package org.viki.services;

import org.viki.model.User;
import org.viki.repositories.LoginRepository;

public class LoginService {
    public User authenticate(String name, String password){
        LoginRepository loginRepository = new LoginRepository();
        User user = loginRepository.getUserDetailsByName(name);

        if(password.equals(user.getPassword())){
            return user;
        }else{
            return null;
        }
    }
}
