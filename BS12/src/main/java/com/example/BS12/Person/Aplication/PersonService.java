package com.example.BS12.Person.Aplication;

import com.example.BS12.Person.Domain.Person;
import com.example.BS12.Person.Infraestructure.DTO.PersonInputDTO;
import com.example.BS12.Person.Infraestructure.DTO.PersonOutputDTO;
import com.example.BS12.Person.Infraestructure.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements PersonImp{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonOutputDTO addPerson(PersonInputDTO personInputDTO) throws Exception {

        Person person = new Person(personInputDTO);
        personRepository.save(person);
        PersonOutputDTO saveOutputDTO = new PersonOutputDTO(person);

        return saveOutputDTO;
    }

    @Override
    public List<PersonOutputDTO> findByName(String name) throws Exception {

        try{

            List<PersonOutputDTO> personByName = personRepository.findByUser(name);
            return personByName;

        } catch (Exception e){
            throw new Exception("Usuario no encontrado");
        }
    }

    @Override
    public PersonOutputDTO findById(String id) throws Exception {

        Person personById = personRepository.findById(Integer.parseInt(id)).orElseThrow(() -> new Exception("No se ha podido encontrar"));
        return new PersonOutputDTO(personById);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public String deleteById(Integer id) throws Exception {

        personRepository.findById(id).orElseThrow(() -> new Exception("No se ha podido encontrar a la persona con id: " + id));
        personRepository.deleteById(id);
        return "Se ha borrado exitosamente a la persona con id: " +id;
    }
}
