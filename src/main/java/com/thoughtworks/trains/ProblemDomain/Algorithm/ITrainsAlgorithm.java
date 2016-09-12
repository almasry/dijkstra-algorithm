package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.Exception.RouteNotFoundException;
import com.thoughtworks.trains.ProblemDomain.Algorithm.Filter.AbstractFilter;

import java.util.ArrayList;

public interface ITrainsAlgorithm
{

    /**
     * @param cities list of the cities that form the route
     * @return length of the route specified
     * @throws RouteNotFoundException if the route wasn't found
     */
    int findLengthOfRoute(ArrayList<String> cities) throws RouteNotFoundException;

    /**
     * @param startCity from which the route starts
     * @param endCity at which the route ends
     * @return the length of the shortest route between the start and end cities
     * @throws RouteNotFoundException if the route wasn't found
     */
    int findLengthOfShortestRoute(String startCity, String endCity) throws RouteNotFoundException;

    /**
     * @param startCity from which the route starts
     * @param endCity at which the route ends
     * @param filter the filter of the operation
     * @return number of trips between the start and end cities
     * @throws RouteNotFoundException if the route wasn't found
     */
    int findNumberOfTrips(String startCity, String endCity, AbstractFilter filter)
            throws RouteNotFoundException;

}

