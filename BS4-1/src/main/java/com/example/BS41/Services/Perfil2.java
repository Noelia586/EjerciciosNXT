package com.example.BS41.Services;

import lombok.Data;
import lombok.With;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
@Data
public class Perfil2 implements Perfil{

    @Value("${perfil2}")
    @Override
    public void myFunction(){

        System.out.println("Perfil2");

    }

}
