package com.example.RS1.Services;

import com.example.RS1.Object.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImp implements PersonService{

    Person person = new Person();
    List<Person> personList = new ArrayList<>();

    @Override
    public Person getPerson(){
        return this.person;
    }

    @Override
    public void setPerson(Person person){
        this.person = person;
    }

    @Override
    public List<Person> getPersonList() {
        return this.personList;
    }

    @Override
    public void addPerson(Person person) {
        this.personList.add(person);
    }

    @Override
    public void removePerson(Integer id) {
        this.personList.removeIf(person1 -> Objects.equals(person1.getId(), id));
    }

    @Override
    public void setId(Integer id) {
        this.person.setId(id);
    }

    @Override
    public Integer getId() {
        return this.person.getId();
    }

    @Override
    public void setName(String name) {
        this.person.setName(name);
    }

    @Override
    public String getName() {
        return this.person.getName();
    }

    @Override
    public void setPopulation(Integer population) {
        this.person.setPopulation(population);
    }

    @Override
    public Integer getPopulation() {
        return this.person.getPopulation();
    }

    @Override
    public void setAge(Integer age) {
        this.person.setAge(age);
    }

    @Override
    public Integer getAge() {
        return this.person.getAge();
    }

    @Override
    public Person findById(Integer id) {
        return personList.stream().filter(person1 -> Objects.equals(person1.getId(), id)).toList().get(0);
    }

    @Override
    public Person findByName(String name) {
        return personList.stream().filter(person1 -> Objects.equals(person1.getName(), name)).toList().get(0);
    }

}
