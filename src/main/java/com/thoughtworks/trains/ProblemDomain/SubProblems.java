package com.thoughtworks.trains.ProblemDomain;

import com.thoughtworks.trains.ProblemDomain.Algorithm.ITrainsAlgorithm;

import java.util.ArrayList;

public class SubProblems
{
    private Solution solution;

    /**
     * @param solution
     * @throws Exception
     */
    public SubProblems(Solution solution) throws Exception
    {
        this.solution = solution;
    }

    /**
     * @return
     * @throws Exception
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
     * @return
     * @throws Exception
     */
    public int solveSubProblem2()throws Exception
    {
        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("D");

        return this.solution.getSolutionAlgorithm().findLengthOfRoute(cities);
    }

    /**
     * @return
     * @throws Exception
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
     * @return
     * @throws Exception
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
     * @return
     * @throws Exception
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
     * @return
     * @throws Exception
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
     * @return
     * @throws Exception
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
     * @return
     * @throws Exception
     */
    public int solveSubProblem8()throws Exception
    {
        return  this.solution
                .getSolutionAlgorithm()
                .findLengthOfShortestRoute("A", "C");
    }

    /**
     * @return
     * @throws Exception
     */
    public int solveSubProblem9()throws Exception
    {
        return  this.solution
                .getSolutionAlgorithm()
                .findLengthOfShortestRoute("B", "B");
    }

    /**
     * @return
     * @throws Exception
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

