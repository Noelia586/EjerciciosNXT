package com.example.EJ31.Person.Infraestructure.Repositories;

import com.example.EJ31.Person.Domain.Model.Person;
import com.example.EJ31.Person.Infraestructure.DTO.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {

    List<PersonOutputDTO> findByUser(String user);

}
