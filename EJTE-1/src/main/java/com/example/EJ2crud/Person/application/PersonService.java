package com.example.EJ2crud.Person.application;

import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Person.infrastructure.dto.PersonInputDTO;
import com.example.EJ2crud.Person.infrastructure.dto.PersonOutputDTO;
import com.example.EJ2crud.Person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonI {

  @Autowired private PersonRepository personRepository;

  @Override
  public PersonOutputDTO addPerson(PersonInputDTO personDTO) throws Exception {
    if (personDTO.getUser().length() < 0 || personDTO.getUser().length() > 10) {
      throw new Exception("El usuario debe tener entre 0 y 10 caracteres");
    } else {
      Person person = new Person(personDTO);
      personRepository.save(person);
      PersonOutputDTO saveOutputDTO = new PersonOutputDTO(person);
      return saveOutputDTO;
    }
  }

  @Override
  public List<PersonOutputDTO> findByName(String name) throws Exception {
    try {
      List<PersonOutputDTO> peopleByName = personRepository.findByName(name);
      return peopleByName;
    } catch (Exception e) {
      throw new Exception("No se ha podido encontrar el usuario");
    }
  }

  @Override
  public PersonOutputDTO findById(Integer id) throws Exception {

    Person peopleById =
        personRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado"));
    return new PersonOutputDTO(peopleById);
  }

  @Override
  public List<PersonOutputDTO> findAll() {
    List<PersonOutputDTO> personOutputDTOList = new ArrayList<>();
    for (Person person : personRepository.findAll()) {
      personOutputDTOList.add(new PersonOutputDTO(person));
    }
    return personOutputDTOList;
  }

  @Override
  public Person deletedById(Integer id) throws Exception {
    Person personToDelete =
        personRepository
            .findById(id)
            .orElseThrow(() -> new Exception("NO se ha encontrado a la persona cuyo id es: " + id));

    personRepository.delete(personToDelete);
    return personToDelete;
  }
}
