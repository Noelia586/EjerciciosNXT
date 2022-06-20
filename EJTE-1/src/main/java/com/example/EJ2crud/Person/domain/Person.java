package com.example.EJ2crud.Person.domain;

import com.example.EJ2crud.Person.infrastructure.dto.PersonInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Person {

  @Id
  @GeneratedValue
  private Integer person_id;

  @NonNull private String user;
  @NonNull private String password;
  @NonNull private String name;
  private String surname;
  @NonNull private String company_email;
  @NonNull private String personal_email;
  @NonNull private String city;
  @NonNull private boolean active;
  @NonNull private Date created_date;
  private String image_url;
  private Date termination_date;

  public Person(PersonInputDTO personDTO) {
    if (personDTO == null) return;
    setPerson_id(personDTO.getPerson_id());
    setUser(personDTO.getUser());
    setPassword(personDTO.getPassword());
    setName(personDTO.getName());
    setSurname(personDTO.getSurname());
    setCompany_email(personDTO.getCompany_email());
    setPersonal_email(personDTO.getPersonal_email());
    setCity(personDTO.getCity());
    setActive(personDTO.isActive());
    setCreated_date(personDTO.getCreated_date());
    setImage_url(personDTO.getImage_url());
    setTermination_date(personDTO.getTermination_date());
  }

}
