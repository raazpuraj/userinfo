package com.user.userinfo.web;


import com.user.userinfo.AuthenticationException;
import com.user.userinfo.dto.Login;

import com.user.userinfo.entity.ArticleData;
import com.user.userinfo.repository.ArticleDataRepository;
import com.user.userinfo.service.ArticleService;
import com.user.userinfo.utility.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.user.userinfo.dto.*;

import com.user.userinfo.dto.UserDto;
import com.user.userinfo.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

  private final UserService userService;

  @Autowired
  private  ArticleService articleService;
  @Autowired
  private TokenService tokenService;
  @Autowired
  ArticleDataRepository repository;

  public UserController(
          UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity register(@Valid @RequestBody UserDto userdto) {
    userService.initiateSignUpProcess(userdto);

    ApiResponse response = new ApiResponse("new user created", null);
    return new ResponseEntity(response, HttpStatus.CREATED);

  }
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody Login login) throws AuthenticationException {
    String email = login.getEmail();
    String password = login.getPassword();
    userService.getUserByEmailAndPassword(email, password);

    String token = tokenService.createJWT("airlcoudpro", "aircloudpro", 259200000l);

    LoginResponseDto loginResponseDto = new LoginResponseDto();
    loginResponseDto.setAccessToken(token);

    ApiResponse response  = new ApiResponse("Success",loginResponseDto);
    return new ResponseEntity(response, HttpStatus.OK);
  }

  @PostMapping("/articles")
  public ResponseEntity article(@Valid @RequestBody ArticleDto article)
  {

    articleService.saveArticle(article);

    String tokencheck = article.getAccess_token();

    HashMap h = tokenService.parseJWT(tokencheck);

    if(h.get("status").equals(1)) {

      ApiResponse response = new ApiResponse("new article created", h);
      return new ResponseEntity(response, HttpStatus.CREATED);
    }

    else {
      ApiResponse negativeResponse = new ApiResponse("Wrong Access token",h);

      return new ResponseEntity(negativeResponse,HttpStatus.FORBIDDEN);
    }


  }

  @GetMapping("/articles")
  public ResponseEntity allArticles()
  {
    List<ArticleData>  data = repository.findAll();

    ApiResponse negativeResponse = new ApiResponse("",data);

    return new ResponseEntity(negativeResponse,HttpStatus.OK);
  }



}



