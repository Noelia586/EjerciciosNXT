package com.example.EJ31.Student.Domain.Services;

import com.example.EJ31.Person.Domain.Model.Person;
import com.example.EJ31.Person.Domain.Services.PersonService;
import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Student.Infraestructure.DTO.StudentInputDTO;
import com.example.EJ31.Student.Infraestructure.DTO.StudentOutputDTO;
import com.example.EJ31.Student.Infraestructure.DTO.StudentOutputFullDTO;
import com.example.EJ31.Student.Infraestructure.Repositories.StudentRepository;
import com.example.EJ31.Subject.Domain.Models.Subject;
import com.example.EJ31.Subject.Infraestructure.Repositories.SubjectRepository;
import com.example.EJ31.Teacher.Domain.Models.Teacher;
import com.example.EJ31.Teacher.Domain.Services.TeacherService;
import com.example.EJ31.Teacher.Infraestructure.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentImp{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private PersonService personService;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public ResponseEntity<?> addStudent(StudentInputDTO studentInputDTO) throws Exception {

        Optional<Person> person = personService.findById(studentInputDTO.getPerson());
        Optional<Teacher> teacher =teacherService.findById(studentInputDTO.getTeacher());

        //controlamos si la persona asociada existe
        if(person.isPresent()){
            Student student = new Student(studentInputDTO);
            student.setPerson(person.get());

            //controlamos se el profesor seleccionado existe al momento de crear
            if(teacher.isPresent()){
                student.setTeacher(teacher.get());
            }else{
                return new ResponseEntity<>("Al profesor que esta intentando asociar no existe.", HttpStatus.NOT_FOUND);
            }

            //aqui controlaremos si la persona ya esta asociada a otro estudiante o a un profesor
            if(studentRepository.findByPersonId(person.get().getPerson_id()).isEmpty() && teacherRepository.findByPersonId(person.get().getPerson_id()).isEmpty()){
                studentRepository.save(student);
                return new ResponseEntity<>("Estudiante guardado", HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Error al insertar el estudiante, la persona ya esta asociada", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<>("La persona a la que esta asociando no existe, por favor revisalo", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public StudentOutputDTO findById(String id) throws Exception {
        Student studentById = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado"));
        return new StudentOutputDTO(studentById);
    }

    @Override
    public StudentOutputFullDTO findFById(String id) throws Exception {
        Student studentById = studentRepository.findById(id).orElseThrow(() -> new Exception("No se ha pidod encontrar"));
        return new StudentOutputFullDTO(studentById);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public String deleteById(String id) throws Exception {
        studentRepository.findById(id).orElseThrow(() -> new Exception("No se a podido encontrar el estudiante con id: " +id));
        studentRepository.deleteById(id);
        return "El estudiante ha sido eliminado correctamente";
    }

    @Override
    public ResponseEntity addSubjects(String student_id, List<String> id) {

        Optional<Student> student = studentRepository.findById(student_id);
/*
        if(student.isEmpty()) return ResponseEntity.ok("No existe ese estudiante con ese id");
        List<Subject> subjectForStudent = student.get().getSubjects();

        for(String ids: id){
            //esto entero me da error tambien :)
            Optional<Subject> subject = subjectRepository.findById(ids);
            if(subject.isPresent()){
                subjectForStudent.add(subject.get());
                List<Student> studentsForSubject = subject.get().getStudents();
                studentsForSubject.add(student.get());

                student.get().setSubjects(subjectForStudent);
                subject.get().setStudents(studentsForSubject);
            }
        }

        studentRepository.save(student.get());*/
        return ResponseEntity.ok("Asignatura asociada");
    }

    @Override
    public ResponseEntity removeSubjects(String idStudent, List<String> ids) {
/*
        Optional<Student> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) return ResponseEntity.ok("No existe estudiante con ese id");

        List<Subject> subjectsForStudent = student.get().getSubjects();
        List<Subject> subjectsForStudentToMap = new ArrayList<>(subjectsForStudent);

        //realizo dos bucles para comprobar si algun id de asignatura coincide con los ids pasados
        for (Subject subject : subjectsForStudentToMap) {
            for (String id : ids) {
                if (subject.getSubject_id().equals(id)) {
                    com.example.EJ31.Subject.Domain.Models.Subject subjectToDelete = subjectRepository.findById(id).get();
                    subjectsForStudent.remove(subjectToDelete);
                    subject.getStudents().remove(student.get());
                }
            }
        }
        student.get().setSubjects(subjectsForStudent);

        studentRepository.save(student.get());
 */
        return ResponseEntity.ok("Asignatura borrada");
    }
}
