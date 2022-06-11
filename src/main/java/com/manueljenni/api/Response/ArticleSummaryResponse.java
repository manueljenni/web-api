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
public class ArticleSummaryResponse {

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
  private String category;

  @Nullable
  private Date publicationDate;

  @Nullable
  private String image;
}
