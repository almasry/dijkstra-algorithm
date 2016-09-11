package com.thoughtworks.trains.Infrastrucure.Storage;

import java.util.ArrayList;

public class HeapStorage<T> implements IStorage<T>{

    private ArrayList<T> repository;

    public HeapStorage(ArrayList<T> object){
        this.repository = object;
    }

    /**
     * {@inheritDoc}
     */
    public void create(T object){
        this.repository.add(object);
    }

    /**
     * {@inheritDoc}
     */
    public ArrayList<T> getAllObjects(){
        return this.repository;
    }
}
