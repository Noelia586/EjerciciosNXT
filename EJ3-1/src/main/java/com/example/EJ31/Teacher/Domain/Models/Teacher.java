package com.example.EJ31.Teacher.Domain.Models;

import com.example.EJ31.Person.Domain.Model.Person;
import com.example.EJ31.StringPrefixedSequenceIdGenerator;
import com.example.EJ31.Student.Domain.Models.Student;
import com.example.EJ31.Teacher.Infraestructure.DTO.TeacherInputDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesor")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqP")
    @GenericGenerator(
            name = "seqP",
            strategy = "com.example.Ej31.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRO"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )

    private String teacherId;

    @OneToOne
    @JoinColumn(name = "person_id")
    Person person;

    @NotNull
    private String branch;
    private String comments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "teacherId")
    private List<Student> students;

    public Teacher(TeacherInputDTO teacherInputDTO){
        setTeacherId(teacherInputDTO.getTeacherId());
        setBranch(teacherInputDTO.getBranch());
        setComments(teacherInputDTO.getComments());
        setStudents(teacherInputDTO.getStudents());
    }
    public Teacher(){

    }

}
