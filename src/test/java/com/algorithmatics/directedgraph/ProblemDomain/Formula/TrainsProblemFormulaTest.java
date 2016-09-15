package com.algorithmatics.directedgraph.ProblemDomain.Formula;

import com.algorithmatics.directedgraph.Exception.InvalidProblemStatementException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrainsProblemFormulaTest {

    @Test
    public void getValidProblemInputs() throws Exception {

        String validProblemFormula1 = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";

        TrainsProblemFormula formula = new TrainsProblemFormula(validProblemFormula1);

        ArrayList<String> expectedEdgesList = new ArrayList<>();

        expectedEdgesList.add("AB5");
        expectedEdgesList.add("BC4");
        expectedEdgesList.add("CD8");
        expectedEdgesList.add("DC8");
        expectedEdgesList.add("DE6");
        expectedEdgesList.add("AD5");
        expectedEdgesList.add("CE2");
        expectedEdgesList.add("EB3");
        expectedEdgesList.add("AE7");

        assertTrue(expectedEdgesList.containsAll(formula.getValidProblemInputs()));

        assertTrue(formula.getValidProblemInputs().containsAll(expectedEdgesList));


        // running another valid test
        expectedEdgesList.clear();

        String validProblemFormula2 = "Graph: AS8, AR160";

        expectedEdgesList.add("AS8");
        expectedEdgesList.add("AR160");

        formula = new TrainsProblemFormula(validProblemFormula2);


        assertTrue(expectedEdgesList.containsAll(formula.getValidProblemInputs()));

        assertTrue(formula.getValidProblemInputs().containsAll(expectedEdgesList));
    }

    @Test (expected = InvalidProblemStatementException.class)
    public void testProblemStatementWithOneEdge() throws InvalidProblemStatementException {

        // testing problem statement with only one edge
        String formulaWithOneEdge = "Graph: AB5";

        TrainsProblemFormula formula = new TrainsProblemFormula(formulaWithOneEdge);

        ArrayList<String> expectedEdgesList = new ArrayList<>();

        expectedEdgesList.add("AB5");

        assertTrue(formula.getValidProblemInputs().containsAll(expectedEdgesList));
    }

    @Test (expected = InvalidProblemStatementException.class)
    public void testProblemStatementWithMissingEdgeLength() throws InvalidProblemStatementException {

        // testing problem statement with only one edge

        String formulaWithMissingNumbers = "Graph: AB5, BEC, CD8, DC8, DE6, AD, CE2, EB3, AE7";

        TrainsProblemFormula formula = new TrainsProblemFormula(formulaWithMissingNumbers);

        ArrayList<String> expectedEdgesList = new ArrayList<>();

        expectedEdgesList.add("AB5");
        expectedEdgesList.add("BEC");
        expectedEdgesList.add("CD8");
        expectedEdgesList.add("DC8");
        expectedEdgesList.add("DE6");
        expectedEdgesList.add("AD");
        expectedEdgesList.add("CE2");
        expectedEdgesList.add("EB3");
        expectedEdgesList.add("AE7");

        assertTrue(formula.getValidProblemInputs().containsAll(expectedEdgesList));
    }

    @Test (expected = InvalidProblemStatementException.class)
    public void testProblemStatementWithRepeatedEdges() throws InvalidProblemStatementException {

        // testing with an edge that has more than one city ( eg. ABD10)
        String formulaWithRepeatedEdges = "Graph: AB5, CD8, DC8, AB2, ABD10";

        TrainsProblemFormula formula = new TrainsProblemFormula(formulaWithRepeatedEdges);

        ArrayList<String> expectedEdgesList = new ArrayList<>();

        expectedEdgesList.add("AB5");
        expectedEdgesList.add("CD8");
        expectedEdgesList.add("DC8");
        expectedEdgesList.add("AB2");
        expectedEdgesList.add("ABD10");

        assertTrue(formula.getValidProblemInputs().containsAll(expectedEdgesList));
    }

}