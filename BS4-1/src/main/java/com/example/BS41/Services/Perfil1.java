package com.example.BS41.Services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil1")
@Data
public class Perfil1 implements Perfil{

    @Value("${perfil1}")
    @Override
    public void myFunction(){

        System.out.println("Perfil1");

    }

}
