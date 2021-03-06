package com.example.BS12.Person.Infraestructure.DTO;

import com.example.BS12.Person.Domain.Person;
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
        setActive(person.getActive());
        setCity(person.getCity());
        setCompany_email(person.getCompany_email());
        setImagen_url(person.getImagen_url());
        setName(person.getName());
        setSurname(person.getSurname());
        setPassword(person.getPassword());
        setPersonal_email(person.getPersonal_email());
        setUser(person.getUser());
        setTerminated_date(person.getTerminated_date());

    }

    public PersonInputDTO(){

    }

}
