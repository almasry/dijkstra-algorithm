package com.thoughtworks.trains;

import com.thoughtworks.trains.Exception.CliApplicationExceptionHandler;
import com.thoughtworks.trains.Utility.IProblemFileReader;
import com.thoughtworks.trains.Utility.IProblemStatementReader;

public class Trains {

    public static void main(String args[]) throws Exception {

        registerApplicationExceptionHandler();

        // can be changed by any other input source
        IProblemStatementReader reader = new IProblemFileReader();
        String problemStatement = reader.getProblemStatement();

    }

    private static void registerApplicationExceptionHandler(){

        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                new CliApplicationExceptionHandler(e);
            }
        });
    }
}


