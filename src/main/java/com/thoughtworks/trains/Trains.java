package com.thoughtworks.trains;

import com.thoughtworks.trains.Exception.CliApplicationExceptionHandler;
import com.thoughtworks.trains.Utility.InputHandler.ProblemFileReader;
import com.thoughtworks.trains.Utility.InputHandler.IProblemStatementReader;

public class Trains {

    /**
     * @param args command line arguments (not currently in use)
     * @throws Exception general application exception handled by CliApplicationExceptionHandler
     */
    public static void main(String args[]) throws Exception {

        Thread.currentThread().setUncaughtExceptionHandler(
                (t, e) -> new CliApplicationExceptionHandler(e)
        );

        // can be changed by any other input source
        IProblemStatementReader reader = new ProblemFileReader();
        String problemStatement = reader.getProblemStatement();
    }
}

 /*

    Running the program :

    java -jar  trains-problem-1.0-SNAPSHOT.jar

    to change the application source class :

    java -cp target/trains-problem-1.0-SNAPSHOT.jar com.thoughtworks.trains.Trains

  */