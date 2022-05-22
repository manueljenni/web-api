package com.manueljenni.api.Result;

import java.util.Date;

public interface ArticleSummaryResult {

  Long getId();

  String getTitle();

  String getSubtitle();

  String getLink();

  String getSummary();

  String getCategory();

  Date getPublicationDate();
}
