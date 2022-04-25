package com.example.DB1EJ2.Person.Infraestructure.Dto;

import com.example.DB1EJ2.Person.Domain.Model.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonInputDTO {

    private int personID;
    private String user, password, name, surname, companyEmail,
        personalEmail, city, imagenURL;
    private Boolean active;
    private Date createDate, terminatedDate;

    public PersonInputDTO(Person person){

        setPersonID(person.getPersonID());
        setActive((person.getActive()));
        setCity(person.getCity());
        setCompanyEmail(person.getCompanyEmail());
        setImagenURL(person.getImagenURL());
        setName(person.getName());
        setSurname(person.getSurname());
        setPassword(person.getPassword());
        setPersonalEmail(person.getPersonalEmail());
        setUser(person.getUser());
        setTerminatedDate(person.getTerminatedDate());

    }

    public PersonInputDTO(){

    }

}
