package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller2 {

    @Autowired
    PersonService personService;

    @Autowired
    CityService cityService;

    @GetMapping("/controller2/getPerson")
    public Person getPersona(){

        personService.setAge(personService.getAge()+personService.getAge());

        return personService.getPerson();
    }
    @GetMapping("/controller2/getCity")
    public List<City> getCity(){

        return cityService.cityList();

    }

    @Autowired
    @Qualifier("bean1")
    Person person1;

    @Autowired
    @Qualifier("bean2")
    Person person2;

    @Autowired
    @Qualifier("bean3")
    Person person3;

    @GetMapping("/controller/bean/{bean}")
    public Person getBean(@PathVariable String bean){

        switch (bean){

            case "bean1" -> {
                return person1;
            }
            case "bean2" -> {
                return person2;
            }
            case "bean3"-> {
                return person3;
            }
            default -> {
                return new Person();
            }

        }

    }

}
