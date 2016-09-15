package com.algorithmatics.directedgraph.ProblemDomain;

import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.ITrainsAlgorithm;
import com.algorithmatics.directedgraph.ProblemDomain.Factory.ProblemElementsFactory;
import com.algorithmatics.directedgraph.ProblemDomain.Formula.IProblemFormula;
import com.algorithmatics.directedgraph.ProblemDomain.Formula.TrainsProblemFormula;
import com.algorithmatics.directedgraph.ProblemDomain.Respository.CityRepository;
import com.algorithmatics.directedgraph.ProblemDomain.Respository.EdgeRepository;

import java.util.ArrayList;

public final class Application {

    private Class<? extends ITrainsAlgorithm> algorithm;
    private String problemStatement;

    private EdgeRepository edgeRepository;
    private CityRepository cityRepository;

    /**
     * @param problemStatement statement as a string parsed or received from input streams
     * @param algorithm the algorithm used to solve the problem
     * @throws Exception if unable to prepare the problem elements
     */
    public Application(String problemStatement, Class<? extends ITrainsAlgorithm> algorithm) throws Exception
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
     * @throws Exception if it fails to prepare the elements needed for the algorithm (both edge and city repositories)
     */
    private void prepareProblem() throws Exception
    {
        // generating problem elements
        ArrayList<String> problemInputs = this.getValidProblemInputs();

        ProblemElementsFactory problemElementsFactory = new ProblemElementsFactory(problemInputs);

        this.edgeRepository = problemElementsFactory.getEdgeRepository();
        this.cityRepository = problemElementsFactory.getCityRepository();
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
