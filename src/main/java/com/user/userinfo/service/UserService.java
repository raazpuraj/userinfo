package com.user.userinfo.service;



import com.user.userinfo.AuthenticationException;
import com.user.userinfo.dto.UserDto;
import com.user.userinfo.entity.UserData;

import java.util.List;
import java.util.Map;

public interface UserService {



  void initiateSignUpProcess( UserDto userdto);
  UserData getUserByEmailAndPassword(String email, String password) throws AuthenticationException;

}
