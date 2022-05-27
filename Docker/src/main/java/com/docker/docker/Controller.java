package com.docker.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("saludo/{name}")
    public String saludo(@PathVariable String name) {
        return "Hola, " + name;

    }

    @GetMapping("adios/{name}")
    public String adios(@PathVariable String name) {
        return "Adios, " + name;

    }
}
