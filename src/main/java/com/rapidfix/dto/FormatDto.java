package com.rapidfix.dto;

import lombok.Data;

import java.util.List;

@Data
public class FormatDto {

  private List<PhoneDto> phone;

  private String text;

}
