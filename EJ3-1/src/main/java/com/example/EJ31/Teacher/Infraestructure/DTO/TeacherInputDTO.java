package com.example.EJ31.Teacher.Infraestructure.DTO;

import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Teacher.Domain.Models.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeacherInputDTO {

    private String teacherId;
    private String branch;
    private String comments;
    private List<Student> students;
    private String person;

    public TeacherInputDTO (Teacher teacher){

        setTeacherId(teacher.getTeacherId());
        setBranch(teacher.getTeacherId());
        setComments(teacher.getComments());
        setStudents(teacher.getStudents());
        setPerson(teacher.getPerson().getPerson_id());
    }

    public TeacherInputDTO(){

    }
}
