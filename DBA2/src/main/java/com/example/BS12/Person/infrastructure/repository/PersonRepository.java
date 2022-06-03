package com.example.BS12.Person.infrastructure.repository;

import com.example.BS12.Person.domain.Person;

import java.util.List;

public interface PersonRepository {

  Person addPerson(Person person);

  List<Person> findAll();

  Person findOneByID(String id);

  void deleteByID(String id);

  Person updatePerson(Person person, String id);
}
