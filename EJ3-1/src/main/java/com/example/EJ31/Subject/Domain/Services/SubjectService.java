package com.example.EJ31.Subject.Domain.Services;

import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Student.Infraestructure.Repositories.StudentRepository;
import com.example.EJ31.Subject.Domain.Models.Subject;
import com.example.EJ31.Subject.Infraestructure.DTO.SubjectInputDTO;
import com.example.EJ31.Subject.Infraestructure.DTO.SubjectOutputDTO;
import com.example.EJ31.Subject.Infraestructure.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectService implements SubjectImp{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public SubjectOutputDTO addSubject(SubjectInputDTO subjectInputDTO) throws Exception {

        if(subjectInputDTO.getSubject_name().length()<0){

            throw new Exception("El nombre de la asignatura debe terne mas de 0 caracteres");
        }else{

            Subject subject = new Subject(subjectInputDTO);
            subjectRepository.save(subject);
            SubjectOutputDTO saveOutputDTO = new SubjectOutputDTO(subject);
            return saveOutputDTO;
        }
    }

    @Override
    public SubjectOutputDTO findById(String id) throws Exception {

        Subject subjectById = subjectRepository.findById(id).orElseThrow(() -> new Exception("No se ha podido encontrar"));
        return new SubjectOutputDTO(subjectById);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public String deleteById(String id) throws Exception {

        subjectRepository.findById(id).orElseThrow(() -> new Exception("No se ha podido encontrar esa asignatura con ese id"));
        subjectRepository.deleteById(id);
        return "Borrado correctamente";
    }

    @Override
    public List<Subject> findByIdStudent(String idStudent) {

        Optional<Student> s = studentRepository.findById(idStudent);
        return s.get().getSubjects();
    }
}
