package com.example.RS1.Controller;

import com.example.RS1.Object.Person;
import com.example.RS1.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("person")
public class ModifyPerson {

    @Autowired PersonService personService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> modifyPerson(@PathVariable int id, @RequestBody Person person){

        Person modifiedPerson = personService.findById(id);

        if(!Objects.isNull(person.getName())){
            modifiedPerson.setName(person.getName());
        }

        if(!Objects.isNull(person.getPopulation())){
            modifiedPerson.setPopulation(person.getPopulation());
        }

        if(!Objects.isNull(person.getAge())){
            modifiedPerson.setAge(person.getAge());
        }

        return ResponseEntity.ok("Enviado");

    }

}
