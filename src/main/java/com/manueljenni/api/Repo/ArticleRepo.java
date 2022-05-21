package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Article;
import com.manueljenni.api.Result.ArticleResult;
import com.manueljenni.api.Result.ArticleSummaryResult;
import com.manueljenni.api.Result.FlightResult;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {

  @Query(value = "SELECT * FROM article WHERE active = 1 ORDER BY publication_date DESC",
      nativeQuery = true
  )
  List<ArticleResult> findAllArticles();

  @Query(value = "SELECT id, title, subtitle, summary, link, publication_date as publicationDate " +
      "FROM article WHERE active = 1 ORDER BY publication_date DESC",
      nativeQuery = true
  )
  List<ArticleSummaryResult> findAllArticlesSummary();

  @Query(value = "SELECT * FROM article WHERE id = ? ORDER BY publication_date DESC",
      nativeQuery = true
  )
  ArticleResult findArticleById(Long id);

  @Query(value = "SELECT id, title, subtitle, summary, link, publication_date AS publicationDate FROM article"
      + "WHERE id = ? ORDER BY publication_date DESC",
      nativeQuery = true
  )
  ArticleSummaryResult findArticleSummaryById(Long id);
}
