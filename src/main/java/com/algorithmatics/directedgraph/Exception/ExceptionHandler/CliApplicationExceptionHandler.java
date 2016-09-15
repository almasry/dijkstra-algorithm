package com.algorithmatics.directedgraph.Exception.ExceptionHandler;

public class CliApplicationExceptionHandler extends Exception {

    public CliApplicationExceptionHandler(Throwable e) {

        System.out.println("Some error happened while processing your input. \n\n" +e.getMessage());

        //TODO: log the stack trace of the exception and do something about it ..
    }
}
