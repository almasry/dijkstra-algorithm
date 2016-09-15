package com.algorithmatics.directedgraph.Infrastrucure.Storage;

import java.util.ArrayList;

public class HeapStorage<T> implements IStorage<T>{

    private ArrayList<T> repository;

    public HeapStorage(ArrayList<T> entity){
        this.repository = entity;
    }

    /**
     * {@inheritDoc}
     */
    public void create(T entity){
        this.repository.add(entity);
    }

    /**
     * {@inheritDoc}
     */
    public ArrayList<T> getAllEntities(){
        return this.repository;
    }
}
