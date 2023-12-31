package org.viki.services;

import org.viki.model.User;
import org.viki.repositories.SignupRepository;

public class SignupService {
    public boolean saveUser(User user){
        SignupRepository signupRepository = new SignupRepository();
        return signupRepository.saveUser(user);
    }
}