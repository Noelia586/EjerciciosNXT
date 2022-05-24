package com.example.EJ31.Person.Domain.Model;

import com.example.EJ31.Person.Infraestructure.DTO.PersonInputDTO;
import com.example.EJ31.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @GenericGenerator(
            name = "seq",
            strategy = "com.example.Ej31.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PER"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
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

    public Person(PersonInputDTO personDTO){
        setPerson_id(personDTO.getPerson_id());
        setActive(personDTO.getActive());
        setCity(personDTO.getCity());
        setCompany_email(personDTO.getCompany_email());
        setImagen_url(personDTO.getImagen_url());
        setName(personDTO.getName());
        setSurname(personDTO.getSurname());
        setPassword(personDTO.getPassword());
        setPersonal_email(personDTO.getPersonal_email());
        setUser(personDTO.getUser());
        setTerminated_date(personDTO.getTerminated_date());
    }

    public Person(){

    }

}
