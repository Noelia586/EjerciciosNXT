package com.example.demo;

import org.springframework.context.annotation.Bean;

public class Beans {

    @Bean("bean1")
    public Person beanPerson1(){
        PersonService personService = new PersonServiceImpl();
        personService.setName("Bean_1");
        personService.setAge(21);
        personService.setPopulation("Logroño");

        return personService.getPerson();
    }

    @Bean("bean2")
    public Person beanPerson2(){
        PersonService personService = new PersonServiceImpl();
        personService.setName("Bean_2");
        personService.setAge(54);
        personService.setPopulation("Madrid");

        return personService.getPerson();
    }

    @Bean("bean3")
    public Person beanPerson3(){
        PersonService personService = new PersonServiceImpl();
        personService.setName("Bean_3");
        personService.setAge(67);
        personService.setPopulation("Andalucia");

        return personService.getPerson();
    }

}
