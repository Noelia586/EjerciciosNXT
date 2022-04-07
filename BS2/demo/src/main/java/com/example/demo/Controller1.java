package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controlador1")
public class Controller1 {

    @Autowired
    PersonService personService;

    @Autowired
    CityService cityService;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        personService.setName(person.getName());
        personService.setPopulation(person.getPopulation());
        personService.setAge(person.getAge());

        return personService.getPerson();
    }

    @PostMapping("/addCity")
    public City addCity(@RequestBody City city){
        cityService.setName(city.getName());
        cityService.setNPopulation(city.getNPopulation());
        cityService.addCity(city);

        return cityService.getCity();
    }

}
