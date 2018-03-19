package com.ctli.enoo.service;

import java.util.List;

import com.ctli.enoo.entity.Article;

public interface IArticleService {
	List<Article> getAllArticles();
	boolean addArticle(Article article);
	void updateArticle(Article article);
	Article getArticleById(int articleId);
	void deleteArticle(int articleId);
}
