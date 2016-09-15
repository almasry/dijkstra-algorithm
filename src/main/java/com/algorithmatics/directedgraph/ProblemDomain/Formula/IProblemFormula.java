package com.algorithmatics.directedgraph.ProblemDomain.Formula;

import com.algorithmatics.directedgraph.Exception.InvalidProblemStatementException;

import java.util.ArrayList;

public interface IProblemFormula {

    /***
     * @return returns an array list of strings (edges data) to be validated and processed later
     * @throws InvalidProblemStatementException if the format of rhe input doesn't match the required input
     */
    ArrayList<String> getValidProblemInputs() throws InvalidProblemStatementException;
}
