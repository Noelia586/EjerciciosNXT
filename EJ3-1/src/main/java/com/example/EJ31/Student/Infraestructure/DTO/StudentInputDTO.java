package com.example.EJ31.Student.Infraestructure.DTO;

import com.example.EJ31.Student.Domain.Models.Student;
import lombok.Getter;
import lombok.Setter;

import javax.security.auth.Subject;
import java.util.List;

@Getter
@Setter
public class StudentInputDTO {

    private String branch;
    private String comments;
    private String student_id;
    private List<Subject> subjects;
    private String person;
    private String teacher;
    private Integer num_hours_week;

    public StudentInputDTO(Student student) {
        setStudent_id(student.getStudent_id());
        setBranch(student.getBranch());
        setComments(student.getComments());
        setPerson(student.getPerson().getPerson_id());
        setTeacher(student.getTeacher().getTeacherId());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
    }

    public StudentInputDTO() {
    }
}
