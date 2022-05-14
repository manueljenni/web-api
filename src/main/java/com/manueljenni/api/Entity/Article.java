package com.manueljenni.api.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {

  @Id
  private Long id;

  private String title;

  private String subtitle;

  private String link;

  private String summary;

  private Date publicationDate;

  private String content;

  private String tags;

  private String image;

  private Boolean active;

}
