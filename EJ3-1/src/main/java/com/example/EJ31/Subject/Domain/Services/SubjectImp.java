package com.example.EJ31.Subject.Domain.Services;

import com.example.EJ31.Subject.Domain.Models.Subject;
import com.example.EJ31.Subject.Infraestructure.DTO.SubjectInputDTO;
import com.example.EJ31.Subject.Infraestructure.DTO.SubjectOutputDTO;

import java.util.List;

public interface SubjectImp {

    public SubjectOutputDTO addSubject(SubjectInputDTO subjectInputDTO) throws Exception;
    SubjectOutputDTO findById(String id) throws Exception;
    List<Subject> findAll();
    String deleteById(String id) throws Exception;
    List<Subject> findByIdStudent(String idStudent);
}
