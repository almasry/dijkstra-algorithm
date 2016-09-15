package com.algorithmatics.directedgraph.ProblemDomain.Algorithm;

import com.algorithmatics.directedgraph.ProblemDomain.Entity.City;

public class Route {

    private City start;

    private City end;

    private int length;

    private int stops;

    private String routeName;

    /**
     * @param start city at which the route starts
     * @param end city at which the route ends
     * @param length length of the route
     * @param stops number of stops along the way of the route
     */
    Route(String routeName, City start, City end, int length, int stops)
    {
        this.routeName = routeName;

        this.start = start;

        this.end = end;

        this.length = length;

        this.stops = stops;
    }

    /**
     * @return length of the route
     */
    public int getLength() {
        return length;
    }

    /**
     * @return number of stops along the way of the route
     */
    public int getNumberOfStops() {
        return stops;
    }

    /**
     * @return city at which the route starts
     */
    City getStart() {
        return start;
    }

    /**
     * @return city at which the route ends
     */
    City getEnd() {
        return end;
    }

    /**
     * @return number of stops along the way of the route
     */
    String getRouteName() {
        return routeName;
    }
}
