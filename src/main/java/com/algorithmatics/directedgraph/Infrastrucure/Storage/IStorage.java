package com.algorithmatics.directedgraph.Infrastrucure.Storage;

import java.util.ArrayList;

/**
 *  IStorage<T> is a generic interface that could be implemented to create a storage layer
 *  (heap storage, database storage ..etc)
 *
 *  For now, this interface comes with only the needed methods for this project and it
 *  can be extended to support full CRUD operations.
 */
public interface IStorage<T> {

    /**
     * @param entity add a new (record) of the object to the storage
     */
    void create(T entity);

    /**
     * @return retrieves all objects in the sotrage
     */
    ArrayList<T> getAllEntities();
}
