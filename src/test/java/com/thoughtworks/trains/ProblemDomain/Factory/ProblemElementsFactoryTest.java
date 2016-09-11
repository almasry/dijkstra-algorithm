package com.thoughtworks.trains.ProblemDomain.Factory;

import com.thoughtworks.trains.ProblemDomain.Entity.City;
import com.thoughtworks.trains.ProblemDomain.Entity.Edge;
import com.thoughtworks.trains.ProblemDomain.Formula.TrainsProblemFormula;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProblemElementsFactoryTest {

    private ProblemElementsFactory problemElmentFactory;

    @Before
    public void setUp() throws Exception {

        String validProblemFormula1 = "Graph: AC100, BA40, CD30, DC81, MN12, AD15, XY10, ZA12";

        ArrayList<String> inputStrings = (new TrainsProblemFormula(validProblemFormula1)).getValidProblemInputs();

        this.problemElmentFactory = new ProblemElementsFactory(inputStrings);

    }

    @Test
    public void getEdgeRepository() throws Exception
    {
        ArrayList<String> expectedEdgesList = new ArrayList<>();

        expectedEdgesList.add("AC100");
        expectedEdgesList.add("BA40");
        expectedEdgesList.add("CD30");
        expectedEdgesList.add("DC81");
        expectedEdgesList.add("MN12");
        expectedEdgesList.add("AD15");
        expectedEdgesList.add("XY10");
        expectedEdgesList.add("ZA12");

        ArrayList<Edge>  citiesInRepository = this.problemElmentFactory.getEdgeRepository().getAllEdges();

        ArrayList<String> edgesRepresentationList = citiesInRepository
                .stream()
                .map(Edge::getEdgeRepresentation)
                .collect(Collectors.toCollection(ArrayList::new));

        assertTrue(edgesRepresentationList.containsAll(expectedEdgesList));

        assertTrue(expectedEdgesList.containsAll(edgesRepresentationList));
    }

    @Test
    public void getCityRepository() throws Exception {
        ArrayList<String> expectedCitiesList = new ArrayList<>();

        expectedCitiesList.add("A");
        expectedCitiesList.add("C");
        expectedCitiesList.add("B");
        expectedCitiesList.add("D");
        expectedCitiesList.add("M");
        expectedCitiesList.add("N");
        expectedCitiesList.add("X");
        expectedCitiesList.add("Y");
        expectedCitiesList.add("Z");

        ArrayList<City>  citiesInRepository = this.problemElmentFactory.getCityRepository().getAllCities();

        ArrayList<String> citiesNamesList = citiesInRepository
                                                .stream()
                                                .map(City::getCityName)
                                                .collect(Collectors.toCollection(ArrayList::new));

        assertTrue(citiesNamesList.containsAll(expectedCitiesList));

        assertTrue(expectedCitiesList.containsAll(citiesNamesList));
    }

}