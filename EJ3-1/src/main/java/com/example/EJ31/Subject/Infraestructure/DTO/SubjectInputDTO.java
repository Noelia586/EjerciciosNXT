package com.example.EJ31.Subject.Infraestructure.DTO;

import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Subject.Domain.Models.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SubjectInputDTO {

    private String subject_id;
    private List<Student> students;
    private String subject_name;
    private String comments;
    private Date initial_date;
    private Date terminated_date;

    public SubjectInputDTO(Subject subject){

        setSubject_id(subject.getSubject_id());
        setStudents(subject.getStudents());
        setSubject_name(subject.getSubject_name());
        setComments(subject.getComments());
        setInitial_date(subject.getInitial_date());
        setTerminated_date(subject.getTerminated_date());

    }
    public SubjectInputDTO(){

    }
}
