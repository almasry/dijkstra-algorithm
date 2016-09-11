package com.thoughtworks.trains.Utility.OutputHandler;

import java.util.concurrent.Callable;

public class PromptSolutionViewer implements ISolutionRenderer {

    private int outputsCounter =0;

    public PromptSolutionViewer() {

        System.out.println("  ================    Solution  ================ ");

    }

    /**
     * {@inheritDoc}
     */
    public PromptSolutionViewer renderOutput(Callable<Integer> callableData) {

        try{
            outputsCounter++;

            System.out.println( "Output # "+ outputsCounter + ": " + callableData.call());

        }catch (Exception e){
            System.out.println( "Output # "+ outputsCounter + ": " + e.getMessage());
        }
        return this;
    }
}
