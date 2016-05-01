package com.lifeisquest.util;

import java.io.Serializable;

/**
 * @author Jason Park
 * @since v1.0
 */
public class ResponseObj implements Serializable {

  private static final long serialVersionUID = -8061403554258897669L;

  private Integer msgCode;

  private String msg;

  private Object data;

  public ResponseObj(Integer msgCode, String msg, Object data) {
    this.msgCode = msgCode;
    this.msg = msg;
    this.data = data;
  }

  public ResponseObj(MessageCode messageCode) {
    this(messageCode.getCode(), messageCode.toString(), null);
  }

  public ResponseObj(MessageCode messageCode, Object object) {
    this(messageCode.getCode(), messageCode.toString(), object);
  }
}
