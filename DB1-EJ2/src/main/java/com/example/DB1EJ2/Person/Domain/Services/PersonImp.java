package com.example.DB1EJ2.Person.Domain.Services;

import com.example.DB1EJ2.Person.Domain.Model.Person;
import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonInputDTO;
import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonOutputDTO;

import java.util.List;

public interface PersonImp {

    PersonOutputDTO addPerson (PersonInputDTO inputDTO) throws Exception;

    List<PersonOutputDTO> findByName(String name) throws Exception;

    PersonOutputDTO findById(int id) throws Exception;

    List<Person> findAll();

    String deleteById(int id) throws Exception;

}
