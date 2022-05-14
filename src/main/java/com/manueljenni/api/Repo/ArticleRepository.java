package com.manueljenni.api.Repo;

import com.manueljenni.api.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
