package com.example.BS12.Person.Infraestructure;


import com.example.BS12.Person.Aplication.PersonService;
import com.example.BS12.Person.Infraestructure.DTO.PersonInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    //Request para añadir una persona a la base de datos

    @PostMapping(value = "/addperson")
    public String addPerson(@RequestBody PersonInputDTO person) throws Exception{
        System.out.println("En el controlador addPerson");
        personService.addPerson(person);
        return "Persona creada correctamente";
    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getall")
    public ResponseEntity getPeople() throws Exception{

        return ResponseEntity.ok(personService.findAll());

    }

}
