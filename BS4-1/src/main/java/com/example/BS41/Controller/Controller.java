package com.example.BS41.Controller;

import com.example.BS41.MyConfiguration;
import com.example.BS41.Services.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired MyConfiguration myConfiguration;
    @Autowired private Perfil perfil;

    @Value("${spring.profiles.active}")
    private String profileValue;

    @Value("${url}")
    private String url;

    @Value("${password}")
    private String password;

    @GetMapping("/parametros")
    public String parameters(){
        return "Los parametros son url: " + url + " y  password: " + password;
    }

    @GetMapping("/miconfiguracion")
    public String settings(){

        return "Mi configuracion es valor1: " + myConfiguration.getValue1()
                + " ,valor2: " + myConfiguration.getValue2();

    }

    @GetMapping("/perfil")
    public String returnProfile(){

        perfil.myFunction();
        return profileValue;

    }

}
