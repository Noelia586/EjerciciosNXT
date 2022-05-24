package com.example.EJ31.Person.Infraestructure.DTO;

import com.example.EJ31.Person.Domain.Model.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonInputDTO {

    private String person_id;
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

    public PersonInputDTO(Person person){

        setPerson_id(person.getPerson_id());
        setUser(person.getUser());
        setPassword(person.getPassword());
        setName(person.getName());
        setSurname(person.getSurname());
        setCompany_email(person.getCompany_email());
        setPersonal_email(person.getPersonal_email());
        setCity(person.getCity());
        setActive(person.getActive());
        setCreate_date(person.getCreate_date());
        setImagen_url(person.getImagen_url());
        setTerminated_date(person.getTerminated_date());

    }

    public PersonInputDTO(){

    }

}
