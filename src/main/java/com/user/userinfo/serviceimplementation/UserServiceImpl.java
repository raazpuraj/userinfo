package com.user.userinfo.serviceimplementation;


import com.user.userinfo.AuthenticationException;
import com.user.userinfo.dto.UserDto;
import com.user.userinfo.repository.UserDataRepository;
import com.user.userinfo.service.UserService;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.*;
import com.user.userinfo.entity.UserData;

@Service
public class UserServiceImpl implements UserService {

    private final UserDataRepository userRepository;


    public UserServiceImpl(
            UserDataRepository userRepository
           ) {

        this.userRepository = userRepository;

    }

    @Override
    public void initiateSignUpProcess(UserDto userdto)
             {
                 UserData userData = new UserData();
                 userData.setUserName(userdto.getUserName());
                 userData.setAddress(userdto.getAddress());
                 userData.setEmail(userdto.getEmailID());
                 userData.setPassword(userdto.getPassword());

                 userRepository.save(userData);

    }

    @Override
    public UserData getUserByEmailAndPassword(String email, String password)  throws AuthenticationException {

        UserData user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new AuthenticationException("Invalid UserId Or Password");
        }
        return user;
    }




}







