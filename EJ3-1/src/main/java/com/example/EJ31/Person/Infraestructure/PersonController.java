package com.example.EJ31.Person.Infraestructure;

import com.example.EJ31.Person.Domain.Services.PersonService;
import com.example.EJ31.Person.Infraestructure.DTO.PersonInputDTO;
import com.example.EJ31.Person.Infraestructure.DTO.PersonOutputDTO;
import com.example.EJ31.Student.Domain.Services.StudentService;
import com.example.EJ31.Teacher.Domain.Models.Teacher;
import com.example.EJ31.Teacher.Domain.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/addPerson")
    public String addPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception{

        personService.addPerson(personInputDTO);
        return "Persona creada correctamente";
    }

    @GetMapping(value = "/getPerson")
    public ResponseEntity getPerson(@RequestParam(defaultValue = "simple") String outputType) throws Exception{

        if(outputType.equals("simple")){
            return ResponseEntity.ok(personService.findAll());
        }else{
            if(outputType.equals("full")){

            }
            return ResponseEntity.ok("No se ha podido obtener los datos de las personas");
        }
    }

    @GetMapping(value = "/getPerson/{id}")
    public PersonOutputDTO getPersonById(@PathVariable String id) throws Exception{
        return new PersonOutputDTO(personService.findById(id).get());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePersonByID(@PathVariable String id) throws Exception{
        return personService.deleteById(id);
    }

    @GetMapping(value = "/getPerson/name/{name}")
    public List<PersonOutputDTO> deletePersonByName(@PathVariable String name) throws Exception{
        return personService.findByName(name);
    }
}
