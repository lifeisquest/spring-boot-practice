package com.grapheople.lifeisquest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

/**
 * @author Steven Jee
 * @since v.
 */
@Data
@Entity
@ToString
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;
  private String email;
  private String phone_number;
  private String password;

  private User() {}

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

}
