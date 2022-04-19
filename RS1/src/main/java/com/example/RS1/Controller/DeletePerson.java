package com.example.RS1.Controller;

import com.example.RS1.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class DeletePerson {

    @Autowired PersonService personService;

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id){

        personService.removePerson(id);
        return ResponseEntity.ok("Eliminado");
    }

}
