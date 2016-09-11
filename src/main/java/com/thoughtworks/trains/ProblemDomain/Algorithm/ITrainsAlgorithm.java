package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.Exception.RouteNotFoundException;

import java.util.ArrayList;

public interface ITrainsAlgorithm
{
    enum Operator { EQUAL, EQUAL_ORL_ESS, EQUAL_OR_MORE, LESS_THAN, MORE_THAN }

    enum ComparisonOperation { LENGTH, NUMBER_OF_STOPS }

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
     * @param algorithmFilter the filter of the operation
     * @param operator the comparison operator used in the algorithm
     * @param operandValue the filter applied to the route selection
     * @return number of trips between the start and end cities
     * @throws RouteNotFoundException if the route wasn't found
     */
    int findNumberOfTrips(String startCity, String endCity, ComparisonOperation algorithmFilter, Operator operator, int operandValue)
            throws RouteNotFoundException;

}

