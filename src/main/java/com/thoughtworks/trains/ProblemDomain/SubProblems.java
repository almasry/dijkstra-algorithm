package com.thoughtworks.trains.ProblemDomain;

import com.thoughtworks.trains.ProblemDomain.Algorithm.ITrainsAlgorithm;

import java.util.ArrayList;

public class SubProblems
{
    private Solution solution;

    /**
     * @param solution Solution objects that gives access to the solution algorithm
     */
    public SubProblems(Solution solution)
    {
        this.solution = solution;
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

        return this.solution.getSolutionAlgorithm().findLengthOfRoute(cities);
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

        return this.solution.getSolutionAlgorithm().findLengthOfRoute(cities);
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

        return this.solution.getSolutionAlgorithm().findLengthOfRoute(cities);
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

        return this.solution.getSolutionAlgorithm().findLengthOfRoute(cities);
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

        return this.solution.getSolutionAlgorithm().findLengthOfRoute(cities);
    }

    /**
     * @return The number of trips starting at C and ending at C with a maximum of 3 stops
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem6()throws Exception
    {
        return this.solution.getSolutionAlgorithm()
                .findNumberOfTrips(
                            "C",
                            "C",
                            ITrainsAlgorithm.ComparisonOperation.NUMBER_OF_STOPS,
                            ITrainsAlgorithm.Operator.EQUAL_ORL_ESS,
                            3
                );
    }

    /**
     * @return The number of trips starting at A and ending at C with exactly 4 stops
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem7()throws Exception
    {
        return  this.solution
                .getSolutionAlgorithm()
                .findNumberOfTrips(
                        "A",
                        "C",
                        ITrainsAlgorithm.ComparisonOperation.NUMBER_OF_STOPS,
                        ITrainsAlgorithm.Operator.EQUAL,
                        4
                );
    }

    /**
     * @return The length of the shortest route (in terms of distance to travel) from A to C
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem8()throws Exception
    {
        return  this.solution
                .getSolutionAlgorithm()
                .findLengthOfShortestRoute("A", "C");
    }

    /**
     * @return The length of the shortest route (in terms of distance to travel) from B to B
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem9()throws Exception
    {
        return  this.solution
                .getSolutionAlgorithm()
                .findLengthOfShortestRoute("B", "B");
    }

    /**
     * @return The number of different routes from C to C with a distance of less than 30
     * @throws Exception if thr route is invalid
     */
    public int solveSubProblem10()throws Exception
    {
        return  this.solution
                .getSolutionAlgorithm()
                .findNumberOfTrips(
                        "C",
                        "C",
                        ITrainsAlgorithm.ComparisonOperation.LENGTH,
                        ITrainsAlgorithm.Operator.LESS_THAN,
                        30
                );
    }
}

