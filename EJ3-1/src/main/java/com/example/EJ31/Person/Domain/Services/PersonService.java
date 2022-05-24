package com.example.EJ31.Person.Domain.Services;

import com.example.EJ31.Person.Domain.Model.Person;
import com.example.EJ31.Person.Infraestructure.DTO.PersonInputDTO;
import com.example.EJ31.Person.Infraestructure.DTO.PersonOutputDTO;
import com.example.EJ31.Person.Infraestructure.Repositories.PersonRepository;
import com.example.EJ31.Student.Infraestructure.Repositories.StudentRepository;
import com.example.EJ31.Teacher.Infraestructure.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonImp{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public PersonOutputDTO addPerson(PersonInputDTO personInputDTO) throws Exception {

        if(personInputDTO.getUser().length()<0 || personInputDTO.getUser().length()>10){
            throw new Exception("El usuario debe tener entre 0 a 10 caracteres");
        }else{
            Person person = new Person(personInputDTO);
            personRepository.save(person);
            PersonOutputDTO saveOutputDTO = new PersonOutputDTO(person);
            return saveOutputDTO;
        }
    }

    @Override
    public List<PersonOutputDTO> findByName(String name) throws Exception {

        try{
            List<PersonOutputDTO> personByName = personRepository.findByUser(name);
            return personByName;

        }catch (Exception e){
            throw new Exception("Usuario no encontrado");
        }
    }

    @Override
    public Optional<Person> findById(String id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteById(String id) throws Exception {

        ResponseEntity response = ResponseEntity.ok("Persona borrada");

        personRepository.findById(id).orElseThrow(() -> new Exception("nose ha podido encontra el usuario con el id: " + id));

        if(teacherRepository.findByPersonId(id).isEmpty()){
            if(studentRepository.findByPersonId(id).isEmpty()){
                personRepository.deleteById(id);
            }else{
                response = ResponseEntity.ok("No se ha podido borrar ya que debria primero borrar al estudiante al que este asociado esta persona");
            }
        }else{
            response = ResponseEntity.ok("No se ha podido bora ya que primero deberias borrar el profesor con el que esta asignado");
        }

        return response;
    }
}
