package com.example.EJ31.Teacher.Infraestructure;

import com.example.EJ31.Teacher.Domain.Models.Teacher;
import com.example.EJ31.Teacher.Domain.Services.TeacherService;
import com.example.EJ31.Teacher.Infraestructure.DTO.TeacherInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/profesor")
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //estamos añadiendo un profesor a la base de datos
    @PostMapping(value = "/addTeacher")
    public ResponseEntity<?> addStudent(@RequestBody TeacherInputDTO teacherInputDTO) throws Exception{
        return teacherService.addTeacher(teacherInputDTO);
    }

    //obtendremos todos los profesores existentes
    @GetMapping(value = "/getTeacher")
    public List<Teacher> getTeacher(){
        return teacherService.findAll();
    }

    @GetMapping(value = "/getTeacher/{id}")
    public Optional<Teacher> getTecherById(@PathVariable String id) throws Exception{
        return teacherService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTeacherById(@PathVariable String id) throws Exception{
        teacherService.deleteById(id);
        return "El profesor con id: " + id + " ha sido eliminado correctamente";
    }

}
