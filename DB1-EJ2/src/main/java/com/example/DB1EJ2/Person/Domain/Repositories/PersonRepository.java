package com.example.DB1EJ2.Person.Domain.Repositories;

import com.example.DB1EJ2.Person.Domain.Model.Person;
import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<PersonOutputDTO> findByUser (String user);

}
