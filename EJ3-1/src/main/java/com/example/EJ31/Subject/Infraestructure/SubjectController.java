package com.example.EJ31.Subject.Infraestructure;

import com.example.EJ31.Subject.Domain.Models.Subject;
import com.example.EJ31.Subject.Domain.Services.SubjectService;
import com.example.EJ31.Subject.Infraestructure.DTO.SubjectInputDTO;
import com.example.EJ31.Subject.Infraestructure.DTO.SubjectOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subject")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "/addSubject")
    public String addSubject(@RequestBody SubjectInputDTO subjectInputDTO) throws Exception{

        subjectService.addSubject(subjectInputDTO);
        return "La asignatura ha sido creada correctamente";
    }

    @GetMapping(value = "/subject/{id}")
    public SubjectOutputDTO getSubject(@PathVariable String id) throws Exception{

        return  subjectService.findById(id);
    }

    @GetMapping(value = "/getSubjects")
    public List<Subject> getSubjects(){
        return subjectService.findAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteSubjectById(@PathVariable String id) throws Exception{
        subjectService.deleteById(id);
        return "La asigantura ha sido eliminada correctamente";
    }

    @GetMapping(value = "/idStudent/{id}")
    public List<Subject> findByIdStudent(@PathVariable String id) throws Exception{
        return subjectService.findByIdStudent(id);
    }

}
