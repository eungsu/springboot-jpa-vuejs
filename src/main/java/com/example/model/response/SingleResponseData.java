package com.example.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResponseData<T> extends ResponseData {
  private T item;
}
