package com.lifeisquest.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jason Park
 * @since v1.0
 */
@Component
@ConfigurationProperties(prefix = "constants")
public class AppConstants {

  private String appName;

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }
}