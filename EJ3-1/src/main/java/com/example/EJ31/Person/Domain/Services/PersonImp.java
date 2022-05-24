package com.example.EJ31.Person.Domain.Services;

import com.example.EJ31.Person.Domain.Model.Person;
import com.example.EJ31.Person.Infraestructure.DTO.PersonInputDTO;
import com.example.EJ31.Person.Infraestructure.DTO.PersonOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersonImp {

    PersonOutputDTO addPerson(PersonInputDTO personInputDTO) throws Exception;
    List<PersonOutputDTO> findByName(String name) throws Exception;
    Optional<Person> findById (String id);
    List<Person> findAll();
    ResponseEntity<?> deleteById(String id) throws Exception;

}
