package com.algorithmatics.directedgraph.ProblemDomain.Respository;

import com.algorithmatics.directedgraph.Infrastrucure.Storage.HeapStorage;
import com.algorithmatics.directedgraph.Infrastrucure.Storage.IStorage;
import com.algorithmatics.directedgraph.ProblemDomain.Entity.Edge;
import com.algorithmatics.directedgraph.ProblemDomain.Entity.City;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EdgeRepository{

    private IStorage<Edge> storage;

    public EdgeRepository()
    {
        ArrayList<Edge> edgeList= new ArrayList<>();
        this.storage = new HeapStorage<>(edgeList);
    }

    /**
     * @return ArrayList of all edges
     */
    public ArrayList<Edge> getAllEdges()
    {
        return this.storage.getAllEntities();
    }

    /**
     * @param edge edge to be added to the edge repository
     */
    public void addEdge(Edge edge)
    {
        for (Edge e : this.storage.getAllEntities())
        {
            if(e.getStart() == edge.getStart() && e.getEnd() == edge.getEnd()) {
                // city has been created before
                return;
            }
        }
        this.storage.create(edge);
    }

    /**
     * @param city city at the start of te edge
     * @return array list of all the edges that start with this specific city
     */
    public ArrayList<Edge> fetchByStartCity(City city)
    {
        return EdgeRepository
                .this.storage.getAllEntities()
                .stream()
                .filter(edge -> edge.getStart().getCityName().equals(city.getCityName()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
