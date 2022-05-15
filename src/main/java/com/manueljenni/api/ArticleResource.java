package com.manueljenni.api;

import com.manueljenni.api.Response.ArticleResponse;
import com.manueljenni.api.Response.ArticleSummaryResponse;
import com.manueljenni.api.Response.FlightResponse;
import com.manueljenni.api.Service.ArticleService;
import com.manueljenni.api.Service.FlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticleResource {

  /*
  access here:
  http://localhost:8080/swagger-ui/index.html
   */

  @Autowired
  ArticleService articleService;

  @GetMapping("/getAllArticles")
  public List<ArticleResponse> allArticles() {
    List<ArticleResponse> articles =  articleService.getAllArticles();
    return articles;
  }

  @GetMapping("/getAllArticlesSummary")
  public List<ArticleSummaryResponse> allArticlesSummary() {
    List<ArticleSummaryResponse> articles =  articleService.getAllArticlesSummary();
    return articles;
  }

  @GetMapping("/getArticleById")
  public ArticleResponse articleById(Long id) {
    ArticleResponse articles =  articleService.getArticleById(id);
    return articles;
  }

  @GetMapping("/getArticleSummaryById")
  public ArticleSummaryResponse articleSummaryById(Long id) {
    ArticleSummaryResponse articles =  articleService.getArticleSummaryById(id);
    return articles;
  }
}
