package com.example.model.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResponseData<T> extends ResponseData {
  private List<T> items;
}
