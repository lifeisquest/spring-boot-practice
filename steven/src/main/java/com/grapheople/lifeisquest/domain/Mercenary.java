package com.grapheople.lifeisquest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * @author Steven Jee
 * @since v.
 */
@Entity
@ToString
@Data
@Table(name = "mercenary")
public class Mercenary {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;
  private String title;
  private String body;
  private long writer_id;
  private String writer;
  private float action_latitude;
  private float action_longitude;
  private String action_location;

  @CreatedDate
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime s_time;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd", timezone="Asia/Seoul")
  private DateTime e_time;
  private int wage;
  private int isDone;

  private Mercenary() {}


}
