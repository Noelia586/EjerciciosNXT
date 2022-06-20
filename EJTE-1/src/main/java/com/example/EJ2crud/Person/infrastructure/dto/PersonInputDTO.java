package com.example.EJ2crud.Person.infrastructure.dto;

import com.example.EJ2crud.Person.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PersonInputDTO {
  private Integer person_id;
  private String user;
  private String password;
  private String name;
  private String surname;
  private String company_email;
  private String personal_email;
  private String city;
  private boolean active;
  private Date created_date;
  private String image_url;
  private Date termination_date;
}
