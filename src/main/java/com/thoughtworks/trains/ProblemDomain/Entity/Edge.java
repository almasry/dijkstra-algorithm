package com.thoughtworks.trains.ProblemDomain.Entity;

public class Edge {

    private City start;

    private City end;

    private int length;

    /**
     * @param start city that starts the edge
     * @param end city at the end of the edge
     * @param distance length of the edge
     */
    public Edge(City start, City end, int distance)
    {
        this.start = start;

        this.end = end;

        this.length = distance;
    }

    /**
     * @return city that starts the edge
     */
    public City getStart()
    {
        return this.start;
    }

    /**
     * @return city at the end of the edge
     */
    public City getEnd()
    {
        return this.end;
    }

    /**
     * @return length of the edge
     */
    public int getEdgeLength()
    {
        return this.length;
    }

    /**
     * @return the string represnation of the edge
     */
    public String getEdgeRepresentation()
    {
        return this.start.getCityName()
                + this.end.getCityName()
                + this.length;
    }
}
