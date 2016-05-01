package com.lifeisquest.controller;

import com.lifeisquest.annotation.Get;
import com.lifeisquest.domain.AppConstants;
import com.lifeisquest.util.MessageCode;
import com.lifeisquest.util.ResponseObj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jason Park
 * @since v1.0
 */
@RestController
@RequestMapping("api")
public class AppController {

  private static final Logger logger = LoggerFactory.getLogger(AppController.class);

  @Autowired
  AppConstants appConstants;

  @Value("${app.server-url}")
  private String appServerUrl;

  @Get("/app/name")
  public ResponseObj getAppName() throws Exception {
    logger.debug("AppName 1");
    logger.info("AppName 2");
    return new ResponseObj(MessageCode.SUCCESS, this.appConstants.getAppName());
  }

  @Get("/app/url")
  public ResponseObj getAppUrl() {
    return new ResponseObj(MessageCode.SUCCESS, this.appServerUrl);
  }
}
