package com.example.BS4.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${var1}")
    private String var1;

    @Value("${var2}")
    private int var2;

    @Value("${var3:var3 no tiene valor")
    private String var3;

    @GetMapping("/valores")
    public String valores(){

        return "valor de var1 es: " + var1 + " valor de my.var2 es:" + var2;

    }

    @GetMapping("/var3")
    public String valor3(){

        return "valor de var3 es: " + var3;

    }

}
