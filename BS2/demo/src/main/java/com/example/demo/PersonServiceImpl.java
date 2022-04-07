package com.example.demo;

public class PersonServiceImpl implements PersonService{

    Person person = new Person();

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public void setName(String name) {
        person.setName(name);
    }

    @Override
    public String getPopulation() {
        return person.getPopulation();
    }

    @Override
    public void setPopulation(String population) {
        person.setPopulation(population);
    }

    @Override
    public int getAge() {
        return person.getAge();
    }

    @Override
    public void setAge(int age) {
        person.setAge(age);
    }

    @Override
    public Person getPerson() {
        return this.person;
    }
}
