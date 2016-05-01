package com.lifeisquest;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jason Park
 * @since v1.0
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
public class SpringBootPracticeApplication {

  public static void main(String[] args) {
    MDC.put("user", "Jason");
    SpringApplication app = new SpringApplication(SpringBootPracticeApplication.class);
//    app.setAdditionalProfiles("prod");
    app.run(args);
  }
}