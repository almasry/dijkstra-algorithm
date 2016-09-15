package com.algorithmatics.directedgraph.ProblemDomain.Respository;

import com.algorithmatics.directedgraph.Infrastrucure.Storage.HeapStorage;
import com.algorithmatics.directedgraph.Infrastrucure.Storage.IStorage;
import com.algorithmatics.directedgraph.ProblemDomain.Entity.City;

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
        for (City c : this.storage.getAllEntities())
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

        for (City c : this.storage.getAllEntities())
        {
            if(c.getCityName().equals(name)) {
                // city has been created before
                return c;
            }
        }
        return null;
    }

    /**
     * @return ArrayList of all cities in storage
     */
    public ArrayList<City> getAllCities()
    {
        return this.storage.getAllEntities();
    }
}
