package com.algorithmatics.directedgraph.ProblemDomain.Formula;

import com.algorithmatics.directedgraph.Exception.InvalidProblemStatementException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainsProblemFormula implements IProblemFormula {

    private String problemStatement;

    private String edgePattern = "[a-zA-Z]{2}\\d+";

    /**
     * @param problemFormula the formula parsed or received from user through GUI or any other input reader
     */
    public TrainsProblemFormula(String problemFormula)
    {
        this.problemStatement = this.cleanseProblemStatement(problemFormula);
    }

    /**
     * {@inheritDoc}
     */
    public ArrayList<String> getValidProblemInputs() throws InvalidProblemStatementException
    {
        this.validateProblemStatement();

        return this.extractValidEdges();
    }

    /**
      * @throws InvalidProblemStatementException if the problem statement doesn't have a t least two edges
     */
    private void validateProblemStatement() throws InvalidProblemStatementException
    {
        String graphString = "Graph:";

        // Validate against general formula (graph: and at least two valid edges)
        String fullFormula = graphString + "(" + this.edgePattern + "),("+ this.edgePattern + ").*" ;

        Pattern formulaPattern = Pattern.compile(fullFormula, Pattern.CASE_INSENSITIVE);

        Matcher validFormula = formulaPattern.matcher(this.problemStatement);

        // checking if the problem statement have a t least two edges
        // why? because this is the minimum you can use to form a graph
        if(! validFormula.lookingAt() ){
            throw new InvalidProblemStatementException("The problem statement doesn't match the standard formula.");
        }
    }

    /**
     * @return ArrayList of possible edges
     */
    private ArrayList<String> extractValidEdges() throws InvalidProblemStatementException
    {
        //Splitting edges
        String edgesStatement = (this.problemStatement.split(":"))[1];
        String[] edgeString = edgesStatement.split(",");

        // Matching exact edge pattern, no more or less (each edge must be of two letters and a number, eg. AB5)
        Pattern pattern = Pattern.compile("\\b"+this.edgePattern +"\\b");

        ArrayList<String> edges = new ArrayList<>();

        for(int i=0; i<edgeString.length; i++){

            Matcher match = pattern.matcher(edgeString[i]);

            if( match.matches() ) {
                edges.add(edgeString[i]);
            } else {
                throw new InvalidProblemStatementException("Edge #" + (i+1) + " is not a valid edge.");
            }
        }
        return edges;
    }

    /**
     * @param problemFormula of the file that is parsed
     * @return cleansed content after removing all white spaces, extra tabs and line feeds
     */
    private String cleanseProblemStatement(String problemFormula)
    {
        return problemFormula
                .trim()
                .replace("\n", " ") // removing line feed
                .replace("\r", " ") // removing unnecessary tabs
                .replaceAll("\\s+", "");
    }
}
