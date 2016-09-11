package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.Exception.RouteNotFoundException;

import java.util.ArrayList;

public interface ITrainsAlgorithm
{
    enum Operator { EQUAL, EQUAL_ORL_ESS, EQUAL_OR_MORE, LESS_THAN, MORE_THAN }

    enum ComparisonOperation { LENGTH, NUMBER_OF_STOPS }

    /**
     * @param cities
     * @return
     * @throws RouteNotFoundException
     */
    int findLengthOfRoute(ArrayList<String> cities) throws RouteNotFoundException;

    /**
     * @param start
     * @param end
     * @return
     * @throws RouteNotFoundException
     */
    int findLengthOfShortestRoute(String start, String end) throws RouteNotFoundException;

    /**
     * @param start
     * @param end
     * @param operation
     * @param operator
     * @param operandValue
     * @return
     * @throws RouteNotFoundException
     */
    int findNumberOfTrips(String start, String end, ComparisonOperation operation, Operator operator, int operandValue)
            throws RouteNotFoundException;

}

