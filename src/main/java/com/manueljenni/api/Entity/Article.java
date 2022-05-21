package com.manueljenni.api.Entity;

import java.time.ZonedDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String title;

  private String subtitle;

  private String link;

  private String summary;

  private Date publicationDate;

  @Lob
  private String content;

  private String tags;

  private String image;

  private Boolean active;

  @UpdateTimestamp
  private ZonedDateTime updatedAt;

}
