package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.ProblemDomain.City;

class Route {

    private City start;

    private City end;

    private int length;

    private int stops;

    /**
     * @param start city at which the route starts
     * @param end city at which the route ends
     * @param length length of the route
     * @param stops number of stops along the way of the route
     */
    Route(City start, City end, int length, int stops)
    {
        this.start = start;

        this.end = end;

        this.length = length;

        this.stops = stops;
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
     * @return length of the route
     */
    int getLength() {
        return length;
    }

    /**
     * @return number of stops along the way of the route
     */
    int getNumberOfStops() {
        return stops;
    }
}
