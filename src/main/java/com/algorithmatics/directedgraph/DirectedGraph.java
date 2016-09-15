package com.algorithmatics.directedgraph;

import com.algorithmatics.directedgraph.Exception.ExceptionHandler.CliApplicationExceptionHandler;
import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.DijkstraAlgorithm;
import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.ITrainsAlgorithm;
import com.algorithmatics.directedgraph.ProblemDomain.Application;
import com.algorithmatics.directedgraph.ProblemDomain.SubProblems;
import com.algorithmatics.directedgraph.Utility.InputHandler.IProblemStatementReader;
import com.algorithmatics.directedgraph.Utility.InputHandler.ProblemFileReader;
import com.algorithmatics.directedgraph.Utility.OutputHandler.IOutputRenderer;
import com.algorithmatics.directedgraph.Utility.OutputHandler.PromptOutputRenderer;

public class DirectedGraph {

    /**
     * @param args command line arguments (not currently in use)
     * @throws Exception general application exception handled by CliApplicationExceptionHandler
     */
    public static void main(String args[]) throws Exception {

        Thread.currentThread().setUncaughtExceptionHandler(
                (t, e) -> new CliApplicationExceptionHandler(e)
        );

        // setting the input source of the problem statement
        IProblemStatementReader reader = new ProblemFileReader();
        String problemStatement = reader.getProblemStatement();

        // creating the solution using DijkstraAlgorithm
        Class<? extends ITrainsAlgorithm> solutionAlgorithm = DijkstraAlgorithm.class;

        Application applicationInstance = new Application(
                problemStatement,
                solutionAlgorithm
        );

        // Solving sub problems and rendering the results
        SubProblems subProblems = new SubProblems(applicationInstance);

        IOutputRenderer solutionViewer = new PromptOutputRenderer();

        solutionViewer
                .renderOutput(subProblems::solveSubProblem1)
                .renderOutput(subProblems::solveSubProblem2)
                .renderOutput(subProblems::solveSubProblem3)
                .renderOutput(subProblems::solveSubProblem4)
                .renderOutput(subProblems::solveSubProblem5)
                .renderOutput(subProblems::solveSubProblem6)
                .renderOutput(subProblems::solveSubProblem7)
                .renderOutput(subProblems::solveSubProblem8)
                .renderOutput(subProblems::solveSubProblem9)
                .renderOutput(subProblems::solveSubProblem10)
        ;
    }
}