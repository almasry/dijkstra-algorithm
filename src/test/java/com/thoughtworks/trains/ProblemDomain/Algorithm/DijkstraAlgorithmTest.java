package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.Exception.RouteNotFoundException;
import com.thoughtworks.trains.ProblemDomain.Solution;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DijkstraAlgorithmTest {

    private Solution solution;

    @Before
    public void setUp() throws Exception {

        this.solution = new Solution(
                "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7",
                DijkstraAlgorithm.class
        );

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findLengthOfRoute() throws Exception {

        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("B");
        cities.add("C");

        assertEquals(9, this.solution.getSolutionAlgorithm().findLengthOfRoute(cities));


        // Anew test
        cities.clear();

        cities.add("A");
        cities.add("D");
        cities.add("C");
        cities.add("D");

        assertEquals(21, this.solution.getSolutionAlgorithm().findLengthOfRoute(cities));


        // Another test
        cities.clear();

        cities.add("D");
        cities.add("C");
        cities.add("D");

        assertEquals(16, this.solution.getSolutionAlgorithm().findLengthOfRoute(cities));


        // one more for the good times
        cities.clear();

        cities.add("A");
        cities.add("D");
        cities.add("C");
        cities.add("E");
        cities.add("B");

        assertEquals(18, this.solution.getSolutionAlgorithm().findLengthOfRoute(cities));
    }

    @Test (expected = RouteNotFoundException.class)
    public void findLengthOfRouteFailure1() throws Exception{

        // testing with invalid route
        ArrayList<String> cities = new ArrayList<>();

        cities.add("A");
        cities.add("C");
        cities.add("E");
        cities.add("B");

        assertEquals(12, this.solution.getSolutionAlgorithm().findLengthOfRoute(cities));
    }

    @Test (expected = NullPointerException.class)
    public void findLengthOfRouteFailure2() throws Exception{

        ArrayList<String> cities = new ArrayList<>();

        // testing with a city that was not part of the problem statement

        cities.add("A");
        cities.add("C");
        cities.add("G");
        cities.add("E");

        assertEquals(12, this.solution.getSolutionAlgorithm().findLengthOfRoute(cities));
    }

    @Test
    public void findLengthOfShortestRoute() throws Exception {

        int lengthOfShortestRoute = this.solution.getSolutionAlgorithm()
                                                 .findLengthOfShortestRoute("B", "B");

        assertEquals(lengthOfShortestRoute, 9);
    }

    @Test
    public void findNumberOfTrips() throws Exception {

        int numberOfTrips = this.solution.getSolutionAlgorithm()
                                         .findNumberOfTrips(
                                              "C",
                                              "C",
                                              ITrainsAlgorithm.ComparisonOperation.NUMBER_OF_STOPS,
                                              ITrainsAlgorithm.Operator.EQUAL_ORL_ESS,
                                              3
                                         );

        assertEquals(numberOfTrips, 2);
    }

}