package com.thoughtworks.trains;

import com.thoughtworks.trains.Exception.ExceptionHandler.CliApplicationExceptionHandler;
import com.thoughtworks.trains.ProblemDomain.*;
import com.thoughtworks.trains.ProblemDomain.Algorithm.*;
import com.thoughtworks.trains.Utility.InputHandler.*;
import com.thoughtworks.trains.Utility.OutputHandler.*;

public class Trains {

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