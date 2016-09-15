package com.algorithmatics.directedgraph.Utility.OutputHandler;

import java.util.concurrent.Callable;

public class PromptOutputRenderer implements IOutputRenderer {

    private int outputsCounter = 0;

    public PromptOutputRenderer() {

        System.out.println("  ================    Solution  ================ ");

    }

    /**
     * {@inheritDoc}
     */
    public PromptOutputRenderer renderOutput(Callable<Integer> callableData) {

        try{
            outputsCounter++;

            System.out.println( "Output # "+ outputsCounter + ": " + callableData.call());

        }catch (Exception e){
            System.out.println( "Output # "+ outputsCounter + ": " + e.getMessage());
        }
        return this;
    }
}
