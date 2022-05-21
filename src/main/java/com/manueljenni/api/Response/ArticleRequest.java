package com.manueljenni.api.Response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {

  private String title;
  private String subtitle;
  private String link;
  private String summary;
  private Date publicationDate;
  private String content;
  private String tags;
  private String image;
  private Boolean active = true;
}
