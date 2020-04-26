package com.user.userinfo.service;


import com.user.userinfo.dto.ArticleDto;
import com.user.userinfo.entity.ArticleData;

import java.util.List;

public interface ArticleService {

    void saveArticle( ArticleDto articleDto);
   // List<ArticleData> findAll();
}
