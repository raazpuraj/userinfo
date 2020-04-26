package com.user.userinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private String title;
    private String body;
    private  String access_token;
    private String author;


}
