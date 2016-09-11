package com.thoughtworks.trains.Exception;

public class CliApplicationExceptionHandler extends Exception {

    public CliApplicationExceptionHandler(Throwable e) {

        System.out.println(e.getMessage());

        // log the stack trace of the exception som where ..
    }
}
