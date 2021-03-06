package com.manueljenni.api.Response;

import com.sun.istack.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse {


  @NotNull
  private Long id;

  @NotNull
  private String title;

  @Nullable
  private String subtitle;

  @NotNull
  private String link;

  @Nullable
  private String summary;

  @Nullable
  private Date publicationDate;

  @Nullable
  private String content;

  @Nullable
  private String category;

  @Nullable
  private String tags;

  @Nullable
  private String image;
}
