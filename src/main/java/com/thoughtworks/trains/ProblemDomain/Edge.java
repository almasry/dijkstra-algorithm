package com.thoughtworks.trains.ProblemDomain;

public class Edge {

    private City start;

    private City end;

    private int length;

    public City getStart()
    {
        return this.start;
    }

    public City getEnd()
    {
        return this.end;
    }

    public int getEdgeLength()
    {
        return this.length;
    }

    public Edge(City start, City end, int distance)
    {
        this.start = start;

        this.end = end;

        this.length = distance;
    }
}
