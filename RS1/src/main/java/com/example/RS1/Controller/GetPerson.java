package com.example.RS1.Controller;

import com.example.RS1.Object.Person;
import com.example.RS1.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class GetPerson {

    @Autowired PersonService personService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id){

        Person person = personService.findById(id);
        return ResponseEntity.ok(person);

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Person> getPersonByName(@PathVariable String name){

        Person person = personService.findByName(name);
        return ResponseEntity.ok(person);

    }

}
