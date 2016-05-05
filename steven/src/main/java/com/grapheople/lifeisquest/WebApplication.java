package com.grapheople.lifeisquest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Steven Jee
 * @since v.
 */
@SpringBootApplication
public class WebApplication {

  public static void main(String[] args) throws Exception{
    SpringApplication.run(WebApplication.class, args);
  }
}
