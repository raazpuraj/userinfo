package com.user.userinfo.serviceimplementation;

import com.user.userinfo.dto.ArticleDto;
import com.user.userinfo.entity.ArticleData;
import com.user.userinfo.repository.ArticleDataRepository;
import com.user.userinfo.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDataRepository articleDataRepository;


    public ArticleServiceImpl(ArticleDataRepository articleDataRepository) {

        this.articleDataRepository = articleDataRepository;

    }

    @Override
    public void saveArticle(ArticleDto articleDto)
    {
        ArticleData articleData = new ArticleData();
        articleData.setAuthor(articleDto.getAuthor());
        articleData.setTitle(articleDto.getTitle());
        articleData.setBody(articleDto.getBody());
        articleData.setAccess_token(articleDto.getAccess_token());


        articleDataRepository.save(articleData);

    }

}
