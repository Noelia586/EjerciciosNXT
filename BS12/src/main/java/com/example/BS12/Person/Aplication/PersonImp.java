package com.example.BS12.Person.Aplication;

import com.example.BS12.Person.Domain.Person;
import com.example.BS12.Person.Infraestructure.DTO.PersonInputDTO;
import com.example.BS12.Person.Infraestructure.DTO.PersonOutputDTO;

import java.util.List;

public interface PersonImp {
    PersonOutputDTO addPerson(PersonInputDTO personInputDTO) throws Exception;
    List<PersonOutputDTO> findByName(String name) throws Exception;
    PersonOutputDTO findById(String id) throws Exception;
    List<Person> findAll();
    String deleteById(Integer id) throws Exception;
}
