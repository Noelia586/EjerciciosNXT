package com.example.demo.Api;

import com.example.demo.Persona.Persona;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;

@RestController

public class Controlador1 {

    @GetMapping("/user/{name}")
    public String getName(@PathVariable String name)
    {
        return "Hola " + name + " Bienvenido :)";
    }

    @PostMapping("/useradd")
    public  String nameJSON(Persona p){

        return "Hola" + p.getNombre() + " vives en: " + p.getCiudad() + " tienes: " +p.getEdad();

    }
}
