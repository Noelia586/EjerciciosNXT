package com.example.BS12.Person.Infraestructure.Repositories;

import com.example.BS12.Person.Domain.Person;
import com.example.BS12.Person.Infraestructure.DTO.PersonOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<PersonOutputDTO> findByUser(String user);
}
