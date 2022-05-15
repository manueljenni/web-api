package com.manueljenni.api.Service;

import com.manueljenni.api.Repo.ArticleRepo;
import com.manueljenni.api.Repo.FlightRepo;
import com.manueljenni.api.Response.ArticleResponse;
import com.manueljenni.api.Response.ArticleSummaryResponse;
import com.manueljenni.api.Result.ArticleResult;
import com.manueljenni.api.Result.ArticleSummaryResult;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

  @Autowired
  ArticleRepo articleRepo;

  public List<ArticleResponse> getAllArticles() {
    List<ArticleResult> articles = articleRepo.findAllArticles();

    return articles.stream()
        .map(articleResult -> {
          ArticleResponse articleResponse = ArticleResponse
              .builder()
              .id(articleResult.getId())
              .title(articleResult.getTitle())
              .subtitle(articleResult.getSubtitle())
              .link(articleResult.getLink())
              .summary(articleResult.getSummary())
              .publicationDate(articleResult.getPublicationDate())
              .content(articleResult.getContent())
              .tags(articleResult.getTags())
              .image(articleResult.getImage())
              .build();
          return articleResponse;
        })
        .collect(Collectors.toList());
  }

  public List<ArticleSummaryResponse> getAllArticlesSummary() {
    List<ArticleSummaryResult> articles = articleRepo.findAllArticlesSummary();

    return articles.stream()
        .map(articleResult -> {
          ArticleSummaryResponse articleResponse = ArticleSummaryResponse
              .builder()
              .id(articleResult.getId())
              .title(articleResult.getTitle())
              .subtitle(articleResult.getSubtitle())
              .link(articleResult.getLink())
              .summary(articleResult.getSummary())
              .publicationDate(articleResult.getPublicationDate())
              .build();
          return articleResponse;
        })
        .collect(Collectors.toList());
  }

  public ArticleResponse getArticleById(Long id) {
    ArticleResult article = articleRepo.findArticleById(id);

    ArticleResponse articleResponse = ArticleResponse
        .builder()
        .id(article.getId())
        .title(article.getTitle())
        .subtitle(article.getSubtitle())
        .link(article.getLink())
        .summary(article.getSummary())
        .publicationDate(article.getPublicationDate())
        .content(article.getContent())
        .tags(article.getTags())
        .image(article.getImage())
        .build();

    return articleResponse;
  }

  public ArticleSummaryResponse getArticleSummaryById(Long id) {
    ArticleSummaryResult article = articleRepo.findArticleSummaryById(id);

    ArticleSummaryResponse articleResponse = ArticleSummaryResponse
        .builder()
        .id(article.getId())
        .title(article.getTitle())
        .subtitle(article.getSubtitle())
        .link(article.getLink())
        .summary(article.getSummary())
        .publicationDate(article.getPublicationDate())
        .build();

    return articleResponse;
  }
}
