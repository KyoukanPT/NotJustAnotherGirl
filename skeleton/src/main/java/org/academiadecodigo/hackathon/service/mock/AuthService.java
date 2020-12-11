package org.academiadecodigo.hackathon.service.mock;

import org.academiadecodigo.hackathon.command.Signin;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User authenticate(Signin signin){
        String email = signin.getEmail();

        for(User user : userService.list()){
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
