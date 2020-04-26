package com.user.userinfo.repository;

import com.user.userinfo.entity.ArticleData;
import com.user.userinfo.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleDataRepository  extends JpaRepository<ArticleData, Long> {

    Optional<ArticleData> findByAuthor(String author);
    Optional<ArticleData> findByBody(String body);
    Optional<ArticleData> findByTitle(String title);
     List<ArticleData> findAll();
}
