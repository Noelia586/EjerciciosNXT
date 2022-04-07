package com.example.demo;

import java.util.List;

public interface CityService {

    String getName();
    void setName(String city);
    int getNPopulation();
    void setNPopulation(int nPopulation);
    void addCity(City city);
    List<City> cityList();
    City getCity();

}
