package com.example.EJ31.Student.Infraestructure.DTO;

import com.example.EJ31.Student.Domain.Models.Student;
import lombok.Getter;
import lombok.Setter;

import javax.security.auth.Subject;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class StudentOutputFullDTO {

    private String branch;
    private String coments;
    private String id_student;
    private List<Subject> subjects;
    private String person;
    private String profesor;
    private Integer num_hours_week;

    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date create_date;
    private String imagen_url;
    private Date terminated_date;

    public StudentOutputFullDTO(Student student){
        setId_student(student.getStudent_id());
        setBranch(student.getBranch());
        setComents(student.getComments());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
        setUser(student.getPerson().getUser());
        setPassword(student.getPerson().getPassword());
        setName(student.getPerson().getName());
        setSurname(student.getPerson().getSurname());
        setCompany_email(student.getPerson().getCompany_email());
        setPersonal_email(student.getPerson().getPersonal_email());
        setCity(student.getPerson().getCity());
        setActive(student.getPerson().getActive());
        setCreate_date(student.getPerson().getCreate_date());
        setImagen_url(student.getPerson().getImagen_url());
        setTerminated_date(student.getPerson().getTerminated_date());
    }

    public StudentOutputFullDTO(){

    }
}
