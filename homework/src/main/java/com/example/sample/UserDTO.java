package com.example.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
  
  private String id;
  private String passwd;
  private String name;
  
}
