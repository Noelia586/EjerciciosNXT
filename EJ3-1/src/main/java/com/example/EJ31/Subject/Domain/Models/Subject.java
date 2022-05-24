package com.example.EJ31.Subject.Domain.Models;

import com.example.EJ31.StringPrefixedSequenceIdGenerator;
import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Subject.Infraestructure.DTO.SubjectInputDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "subject")
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_su")
    @GenericGenerator(
            name = "seq_su",
            strategy = "com.example.Ej31.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SUB"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String subject_id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "student_subject",
            joinColumns = {@JoinColumn(name = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "id_student")}
    )
    @JsonIgnore
    private List<Student> students;

    private String subject_name;

    private String comments;

    private Date initial_date;

    private Date terminated_date;


    public Subject(SubjectInputDTO subjectDto){
        setSubject_id(subjectDto.getSubject_id());
        setComments(subjectDto.getComments());
        setStudents(subjectDto.getStudents());
        setTerminated_date(subjectDto.getTerminated_date());
        setInitial_date(subjectDto.getInitial_date());
        setSubject_name(subjectDto.getSubject_name());
    }

    public Subject(){}

}
