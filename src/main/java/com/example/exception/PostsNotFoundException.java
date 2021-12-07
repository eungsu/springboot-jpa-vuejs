package com.example.exception;

public class PostsNotFoundException extends ApplicationException {
  public PostsNotFoundException(int code, String message) {
    super(code, message);
  }
}
