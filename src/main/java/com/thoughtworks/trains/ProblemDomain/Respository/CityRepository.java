package com.thoughtworks.trains.ProblemDomain.Respository;

import com.thoughtworks.trains.Infrastrucure.Storage.HeapStorage;
import com.thoughtworks.trains.Infrastrucure.Storage.IStorage;
import com.thoughtworks.trains.ProblemDomain.City;

import java.util.ArrayList;

public class CityRepository{

    private IStorage<City> storage;

    public CityRepository(){
        this.storage = new HeapStorage<>(new ArrayList<City>());
    }


    /**
     * @param city that we want add to the cities list
     */
    public void addCity(City city){

        // checking if the city is already registered in the cities list
        for (City c : this.storage.getAllObjects())
        {
            if(c.getCityName().equals(city.getCityName())) {
                // city has been created before
                return;
            }
        }
        this.storage.create(city);
    }

    /**
     * @param name String name of the city we're looking for
     * @return City | null
     */
    public City getCityByName(String name) {

        for (City c : this.storage.getAllObjects())
        {
            if(c.getCityName().equals(name)) {
                // city has been created before
                return c;
            }
        }
        return null;
    }
}
