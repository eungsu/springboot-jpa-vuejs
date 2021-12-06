package com.example.model.response;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResponseService {
  public enum ResponseStatus {
    SUCCESS(0, "성공"), FAIL(-1, "실패");
    int code;
    String message;

    ResponseStatus(int code, String message) {
      this.code = code;
      this.message = message;
    }

    public int getCode() {
      return code;
    }
    public String getMessage() {
      return message;
    }
  }

  public <T> SingleResponseData<T> getResponseData(T item) {
    SingleResponseData<T> responseData = new SingleResponseData<>();
    responseData.setItem(item);
    responseData.setSuccess(true);
    responseData.setCode(ResponseStatus.SUCCESS.getCode());
    responseData.setMessage(ResponseStatus.SUCCESS.getMessage());
    return responseData;
  }

  public <T> ListResponseData<T> getResponseData(List<T> items) {
    ListResponseData<T> responseData = new ListResponseData<>();
    responseData.setItems(items);
    responseData.setSuccess(true);
    responseData.setCode(ResponseStatus.SUCCESS.getCode());
    responseData.setMessage(ResponseStatus.SUCCESS.getMessage());
    return responseData;
  }

  public ResponseData getSuccessResponse() {
    return getResponseData(true, ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMessage());
  }

  public ResponseData getFailResponse(int code, String message) {
    return getResponseData(false, code, message);
  }

  private ResponseData getResponseData(boolean success, int code, String message) {
    ResponseData responseData = new ResponseData();
    responseData.setSuccess(success);
    responseData.setCode(code);
    responseData.setMessage(message);
    return responseData;
  }
}
