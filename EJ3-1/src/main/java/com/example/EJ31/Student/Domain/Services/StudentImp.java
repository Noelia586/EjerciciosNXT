package com.example.EJ31.Student.Domain.Services;

import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Student.Infraestructure.DTO.StudentInputDTO;
import com.example.EJ31.Student.Infraestructure.DTO.StudentOutputDTO;
import com.example.EJ31.Student.Infraestructure.DTO.StudentOutputFullDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentImp {

    public ResponseEntity<?> addStudent(StudentInputDTO studentDTO) throws Exception;

    StudentOutputDTO findById(String id) throws Exception;
    StudentOutputFullDTO findFById(String id) throws Exception;
    List<Student> findAll();
    String deleteById(String id) throws Exception;
    ResponseEntity addSubjects(String student_id, List<String> id);
    ResponseEntity removeSubjects(String student_id, List<String>id);
}
