package com.example.RS1.Controller;

import com.example.RS1.Object.Person;
import com.example.RS1.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class AddPerson {

    @Autowired PersonService personService;

    @PostMapping()
    public ResponseEntity<List> addPerson(@RequestBody Person person){

        personService.getPersonList().add(person);
        return ResponseEntity.ok(personService.getPersonList());

    }
}
