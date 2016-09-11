package com.thoughtworks.trains.ProblemDomain;

import com.thoughtworks.trains.ProblemDomain.Algorithm.*;
import com.thoughtworks.trains.ProblemDomain.Factory.*;
import com.thoughtworks.trains.ProblemDomain.Formula.*;
import com.thoughtworks.trains.ProblemDomain.Respository.*;

import java.util.ArrayList;

public final class Solution {

    private Class<? extends ITrainsAlgorithm> algorithm;
    private String problemStatement;

    private EdgeRepository edgeRepository;
    private CityRepository cityRepository;

    /**
     * @param problemStatement statement as a string parsed or received from input streams
     * @param algorithm the algorithm used to solve the problem
     * @throws Exception if unable to prepare the problem elements
     */
    public Solution(String problemStatement, Class<? extends ITrainsAlgorithm> algorithm) throws Exception
    {
        this.problemStatement = problemStatement;
        this.algorithm = algorithm;
        this.prepareProblem();
    }

    /**
     * @return a new instance of the the algorithm
     * @throws Exception in case if it fails to instantiate the algorithm constructor
     */
    public ITrainsAlgorithm getSolutionAlgorithm() throws Exception
    {
        // creates a new instance of the solution algorithm every time it is called
        return this.algorithm
                .getConstructor(EdgeRepository.class, CityRepository.class)
                .newInstance(this.edgeRepository, this.cityRepository);
    }

    /**
     * @throws Exception if it fails to prepare the inputs needed for the algorithm (edge and city repositories)
     */
    private void prepareProblem() throws Exception
    {
        // generating problem elements
        ArrayList<String> problemInputs = this.getValidProblemInputs();

        ProblemFactory problemFactory = new ProblemFactory(problemInputs);

        this.edgeRepository = problemFactory.getEdgeRepository();
        this.cityRepository = problemFactory.getCityRepository();
    }

    /**
     * @return an array of valid problem elements (edges in this case)
     * @throws Exception if the problem statement or the inputs are invalid
     */
    private ArrayList<String> getValidProblemInputs() throws Exception
    {
        IProblemFormula formula = new TrainsProblemFormula(this.problemStatement);

        return formula.getValidProblemInputs();
    }
}
