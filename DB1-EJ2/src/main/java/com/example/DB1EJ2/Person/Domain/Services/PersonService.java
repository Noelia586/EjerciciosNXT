package com.example.DB1EJ2.Person.Domain.Services;

import com.example.DB1EJ2.Person.Domain.Model.Person;
import com.example.DB1EJ2.Person.Domain.Repositories.PersonRepository;
import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonInputDTO;
import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements PersonImp{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonOutputDTO addPerson(PersonInputDTO inputDTO) throws Exception {

        if(inputDTO.getUser().length()<0 || inputDTO.getUser().length()>10){

            throw new Exception("Longitud de usuario no debe ser superior a 10 caracteres");

        }else{

            Person person = new Person(inputDTO);
            personRepository.save(person);
            PersonOutputDTO saveOutputDTO = new PersonOutputDTO(person);

            return saveOutputDTO;

        }
    }

    @Override
    public List<PersonOutputDTO> findByName(String name) throws Exception {

        try{

            List<PersonOutputDTO> peopleByName = personRepository.findByUser(name);
            return peopleByName;

        }catch (Exception e){

            throw new Exception("No se ha encontrado el usuario");

        }
    }

    @Override
    public PersonOutputDTO findById(int id) throws Exception {

        Person peopleById = personRepository.findById(id).orElseThrow(()-> new Exception("No se ha encontrado"));
        return new PersonOutputDTO(peopleById);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public String deleteById(int id) throws Exception {

        personRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado a la persona cuyo id es: "+id));
        personRepository.deleteById(id);
        return "La persona cuyo es id es "+id+" ha sido borrada";

    }
}
