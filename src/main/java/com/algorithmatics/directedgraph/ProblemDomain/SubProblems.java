package com.algorithmatics.directedgraph.ProblemDomain;

import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Filter.AbstractFilter;
import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Filter.NumberOfStopsFilter;
import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Filter.RouteLengthFilter;

import java.util.ArrayList;

public class SubProblems
{
    private Application application;

    /**
     * @param solution Application objects that gives access to the application algorithm
     */
    public SubProblems(Application solution)
    {
        this.application = solution;
    }

    /**
     * @return The distance of the route A-B-C
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem1()throws Exception
    {
        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("B");
        cities.add("C");

        return this.application.getSolutionAlgorithm().findLengthOfRoute(cities);
    }

    /**
     * @return The distance of the route A-D
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem2()throws Exception
    {
        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("D");

        return this.application.getSolutionAlgorithm().findLengthOfRoute(cities);
    }

    /**
     * @return The distance of the route A-D-C
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem3()throws Exception
    {
        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("D");
        cities.add("C");

        return this.application.getSolutionAlgorithm().findLengthOfRoute(cities);
    }

    /**
     * @return The distance of the route A-E-B-C-D
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem4()throws Exception
    {
        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("E");
        cities.add("B");
        cities.add("C");
        cities.add("D");

        return this.application.getSolutionAlgorithm().findLengthOfRoute(cities);
    }

    /**
     * @return The distance of the route A-E-D
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem5()throws Exception
    {
        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("E");
        cities.add("D");

        return this.application.getSolutionAlgorithm().findLengthOfRoute(cities);
    }

    /**
     * @return The number of trips starting at C and ending at C with a maximum of 3 stops
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem6()throws Exception
    {
        AbstractFilter filter = new NumberOfStopsFilter(
                                AbstractFilter.Operator.EQUAL_ORL_ESS,
                                3
                        );

        return this.application
                .getSolutionAlgorithm()
                .findNumberOfTrips("C","C", filter);
    }

    /**
     * @return The number of trips starting at A and ending at C with exactly 4 stops
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem7()throws Exception
    {
        AbstractFilter filter = new NumberOfStopsFilter(
                AbstractFilter.Operator.EQUAL,
                4
        );

        return  this.application
                .getSolutionAlgorithm()
                .findNumberOfTrips( "A","C", filter);
    }

    /**
     * @return The length of the shortest route (in terms of distance to travel) from A to C
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem8()throws Exception
    {
        return  this.application
                .getSolutionAlgorithm()
                .findLengthOfShortestRoute("A", "C");
    }

    /**
     * @return The length of the shortest route (in terms of distance to travel) from B to B
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem9()throws Exception
    {
        return  this.application
                .getSolutionAlgorithm()
                .findLengthOfShortestRoute("B", "B");
    }

    /**
     * @return The number of different routes from C to C with a distance of less than 30
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem10()throws Exception
    {
        AbstractFilter filter = new RouteLengthFilter(
                AbstractFilter.Operator.LESS_THAN,
                30
        );

        return  this.application
                .getSolutionAlgorithm()
                .findNumberOfTrips("C", "C", filter);
    }
}

