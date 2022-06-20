package com.example.EJ2crud.Person.infrastructure;

import com.example.EJ2crud.Person.application.PersonService;
import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Person.infrastructure.dto.PersonInputDTO;
import com.example.EJ2crud.Person.infrastructure.dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person/crud")
public class PersonController {

  @Autowired PersonService personService;

  // Request para insertar una persona en la base de datos
  @PostMapping("/addPerson")
  public PersonOutputDTO insertPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception {
    System.out.println("En el controlador addPerson");
    return personService.addPerson(personInputDTO);
  }

  // Request para obtener todos los registros de la tabla
  @GetMapping(value = "/getPeople")
  public List<PersonOutputDTO> getPeople() {
    System.out.println("En el controlador getPeople");
    return personService.findAll();
  }

  // Request para obtener la persona con id pasado por parámetro
  @GetMapping(value = "/getPerson/{id}")
  public PersonOutputDTO getPersonById(@PathVariable Integer id) throws Exception {
    return personService.findById(id);
  }

  // Request para eliminar la persona con id pasado por parámetro
  @DeleteMapping(value = "/delete/{id}")
  public Person deletePersonById(@PathVariable Integer id) throws Exception {

    return personService.deletedById(id);
  }

  // Request para obtener la persona con nombre pasado por parámetro
  @GetMapping(value = "/getPeople/name/{name}")
  public List<PersonOutputDTO> getPeopleByName(@PathVariable String name) throws Exception {
    return personService.findByName(name);
  }
}
