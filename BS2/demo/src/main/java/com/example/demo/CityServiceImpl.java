package com.example.demo;

import java.util.*;

public class CityServiceImpl implements CityService{

    List<City> cityList = new ArrayList<>();
    City c = new City();

    @Override
    public String getName() {
        return c.getName();
    }

    @Override
    public void setName(String name) {
        c.setName(name);
    }

    @Override
    public int getNPopulation() {
        return c.getNPopulation();
    }

    @Override
    public void setNPopulation(int nPopulation) {
        c.setNPopulation(nPopulation);
    }

    @Override
    public void addCity(City city) {
        cityList.add(city);
    }

    @Override
    public List<City> cityList() {
        return this.cityList;
    }

    @Override
    public City getCity() {
        return this.c;
    }
}
