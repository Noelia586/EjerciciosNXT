package com.example.EJ31.Student.Infraestructure;

import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Student.Domain.Services.StudentService;
import com.example.EJ31.Student.Infraestructure.DTO.StudentInputDTO;
import com.example.EJ31.Student.Infraestructure.DTO.StudentOutputDTO;
import com.example.EJ31.Student.Infraestructure.DTO.StudentOutputFullDTO;
import com.example.EJ31.Student.Infraestructure.Repositories.StudentRepository;
import com.example.EJ31.Subject.Domain.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectService subjectService;

    @PostMapping(value = "/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentInputDTO studentInputDTO) throws Exception{
        return studentService.addStudent(studentInputDTO);
    }

    @GetMapping(value = "/estudiante/{id}")
    public ResponseEntity getStudent(@PathVariable String id, @RequestParam(defaultValue = "simple") String outputType) throws Exception{

        if(outputType.equals("simple")){
            StudentOutputDTO studentSimple = studentService.findById(id);
            return ResponseEntity.ok(studentSimple);
        }else{
            if(outputType.equals("full")){
                StudentOutputFullDTO studentFull = studentService.findFById(id);
                return ResponseEntity.ok(studentFull);
            }
            return ResponseEntity.ok("No se ha podido encontrar");
        }
    }
    @GetMapping(value = "/getStudent")
    public List<Student> getStudent(){
        return studentService.findAll();
    }

    @GetMapping(value = "/getStudent/{id}")
    public StudentOutputDTO getStudentById(@PathVariable String id) throws Exception{
        return studentService.findById(id);
    }

    @DeleteMapping(value = "/delte/{id}")
    public String deleteStudentById(@PathVariable String id) throws Exception{
        studentService.deleteById(id);
        return "El estudiante con id: " + " ha sido eliminado correctamente";
    }

    @PutMapping(value = "/addSubject/{idStudent}")
    public ResponseEntity addSubject(@PathVariable String studentId, @RequestBody List<String> id) throws Exception{
        return studentService.removeSubjects(studentId, id);
    }
}
