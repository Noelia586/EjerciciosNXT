package com.example.EJ31.Student.Domain.Models;

import com.example.EJ31.Person.Domain.Model.Person;
import com.example.EJ31.StringPrefixedSequenceIdGenerator;
import com.example.EJ31.Student.Infraestructure.DTO.StudentInputDTO;
import com.example.EJ31.Teacher.Domain.Models.Teacher;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter

public class Student {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStudent")
    @GenericGenerator(
            name = "seqStudent",
            strategy = "com.example.Ej31.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STU"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String student_id;

    @ManyToMany(mappedBy = "student")
    private List<Subject> subjects;

    @OneToOne
    @JoinColumn(name = "person_id")
    @NotNull
    Person person;

    @NotNull
    private Integer num_hours_week;

    @NotNull
    private String branch;

    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    public Student(StudentInputDTO studentInputDTO) throws Exception {

        setStudent_id(studentInputDTO.getStudent_id());
        setBranch(studentInputDTO.getBranch());
        setComments(studentInputDTO.getComments());
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setSubjects(studentInputDTO.getSubjects());
    }

    public Student(){

    }
}
