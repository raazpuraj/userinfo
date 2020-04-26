package com.user.userinfo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ArticleData")
@Data
public class ArticleData {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "author")
    private String author;

    @Column(name = "access_token")
    private String access_token;


}
