package com.manueljenni.api.Result;

import java.util.Date;

public interface ArticleResult {

  Long getId();

  String getTitle();

  String getSubtitle();

  String getLink();

  String getSummary();

  Date getPublicationDate();

  String getContent();

  String getTags();

  String getImage();

  Boolean getActive();
}
