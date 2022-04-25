package com.example.DB1EJ2.Person.Infraestructure;

import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonInputDTO;
import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonOutputDTO;
import com.example.DB1EJ2.Person.Domain.Model.Person;
import com.example.DB1EJ2.Person.Domain.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Controller {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/addPerson")
    public String addPerson(@RequestBody PersonInputDTO person) throws Exception{

        System.out.println("addPerson");
        personService.addPerson(person);
        return "Persona creada correctamente";
    }

    @GetMapping(value = "/getPerson")
    public List<Person> getPerson(){

        return personService.findAll();
    }

    @GetMapping(value = "/getPerson/{id}")
    public PersonOutputDTO getPersonById(@PathVariable int id) throws Exception{
        return personService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deletePersonById(@PathVariable int id) throws Exception{
        personService.deleteById(id);
        return "La persona ha sido eliminada correctamente";
    }

    @GetMapping(value = "/getPerson/ name/{name}")
    public List<PersonOutputDTO> deletePersonByName(@PathVariable String name) throws Exception{
        return personService.findByName(name);
    }

}
