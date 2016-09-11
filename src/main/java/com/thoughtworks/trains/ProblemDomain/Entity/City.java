package com.thoughtworks.trains.ProblemDomain.Entity;

public class City {

    private String cityName;

    /**
     * @param cityName name of the city
     */
    public City(String cityName)
    {
        this.cityName = cityName;
    }

    /**
     * @return name of the city
     */
    public String getCityName() {
        return this.cityName;
    }
}
