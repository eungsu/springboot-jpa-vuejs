package com.example.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {
  private boolean success;
  private int code;
  private String message;
}
