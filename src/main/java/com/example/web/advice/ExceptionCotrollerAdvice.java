package com.example.web.advice;

import com.example.model.response.ResponseData;
import com.example.model.response.ResponseService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionCotrollerAdvice {
  private final ResponseService responseService;

  @ExceptionHandler(Exception.class)
  protected ResponseData handleException() {
    return responseService.getFailResponse(-999, "서버에서 알 수 없는 오류가 발생하였습니다.");
  }

  @ExceptionHandler(IllegalArgumentException.class) 
  protected ResponseData handleIllegalArgumentException(){
    return responseService.getFailResponse(-100, "파라미터값이 유효하지 않습니다.");
  }
}
