package com.example.EJ31.Teacher.Domain.Services;

import com.example.EJ31.Person.Domain.Model.Person;
import com.example.EJ31.Person.Domain.Services.PersonService;
import com.example.EJ31.Student.Infraestructure.Repositories.StudentRepository;
import com.example.EJ31.Teacher.Domain.Models.Teacher;
import com.example.EJ31.Teacher.Infraestructure.DTO.TeacherInputDTO;
import com.example.EJ31.Teacher.Infraestructure.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherImp{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity<?> addTeacher(TeacherInputDTO teacherInputDTO) throws Exception {

        Optional<Person> person = personService.findById(teacherInputDTO.getPerson());

        if(person.isPresent()){
            Teacher teacher = new Teacher(teacherInputDTO);
            teacher.setPerson(person.get());

            if (teacherRepository.findByPersonId(person.get().getPerson_id()).isEmpty() && studentRepository.findByPersonId(person.get().getPerson_id()).isEmpty()){
                teacherRepository.save(teacher);
                return new ResponseEntity<>("profesor creado y guardado correctamente", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Error al crear el profesor , la preson que ha puesto ya tiene un profesor", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>("No se puede crear ya que la persona a la que quiere asociarla no ha sido encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Optional<Teacher> findById(String id) throws Exception {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public String deleteById(String id) throws Exception {

        teacherRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado ese profesor con ese id"));
        teacherRepository.deleteById(id);
        return "El profesor con id " + id + " ha sido eliminado correctamente";
    }
}
