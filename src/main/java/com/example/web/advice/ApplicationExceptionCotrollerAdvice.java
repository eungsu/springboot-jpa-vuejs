package com.example.web.advice;

import com.example.exception.ApplicationException;
import com.example.model.response.ResponseData;
import com.example.model.response.ResponseService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ApplicationExceptionCotrollerAdvice {
  private final ResponseService responseService;

  @ExceptionHandler(Exception.class)
  protected ResponseData handleException() {
    return responseService.getFailResponse(-9999, "서버에서 알 수 없는 오류가 발생하였습니다.");
  }

  @ExceptionHandler(ApplicationException.class) 
  protected ResponseData handleIllegalArgumentException(ApplicationException ex){
    return responseService.getFailResponse(ex.getCode(), ex.getMessage());
  }
}
