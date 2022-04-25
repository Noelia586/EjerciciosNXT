package com.example.DB1EJ2.Person.Domain.Model;

import com.example.DB1EJ2.Person.Infraestructure.Dto.PersonInputDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue

    private int personID;
    private String user, password, name, surname, companyEmail,
        personalEmail, city, imagenURL;
    private Boolean active;
    private Date createDate, terminatedDate;

    public Person (PersonInputDTO personInputDTO){

        setPersonID(personInputDTO.getPersonID());
        setActive(personInputDTO.getActive());
        setCity(personInputDTO.getCity());
        setCompanyEmail(personInputDTO.getCompanyEmail());
        setImagenURL(personInputDTO.getImagenURL());
        setName(personInputDTO.getName());
        setSurname(personInputDTO.getSurname());
        setPassword(personInputDTO.getPassword());
        setPersonalEmail(personInputDTO.getPersonalEmail());
        setUser(personInputDTO.getUser());
        setTerminatedDate(personInputDTO.getTerminatedDate());

    }

    public Person(){

    }

}
