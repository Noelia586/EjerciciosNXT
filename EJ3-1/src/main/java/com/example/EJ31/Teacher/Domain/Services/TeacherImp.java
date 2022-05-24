package com.example.EJ31.Teacher.Domain.Services;

import com.example.EJ31.Teacher.Domain.Models.Teacher;
import com.example.EJ31.Teacher.Infraestructure.DTO.TeacherInputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherImp {

    ResponseEntity<?> addTeacher(TeacherInputDTO teacherInputDTO) throws Exception;
    Optional<Teacher> findById(String id) throws Exception;
    List<Teacher> findAll();
    String deleteById(String id) throws Exception;
}
