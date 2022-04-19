package com.example.RS1.Services;

import com.example.RS1.Object.Person;

import java.util.List;

public interface PersonService {

    Person getPerson();
    void setPerson(Person person);
    List<Person> getPersonList();
    void addPerson(Person person);
    void removePerson(Integer id);
    void setId(Integer id);
    Integer getId();
    void setName(String name);
    String getName();
    void setPopulation(Integer population);
    Integer getPopulation();
    void setAge(Integer age);
    Integer getAge();
    Person findById(Integer id);
    Person findByName(String name);

}
