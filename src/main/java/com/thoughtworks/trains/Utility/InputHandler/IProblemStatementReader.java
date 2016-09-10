package com.thoughtworks.trains.Utility.InputHandler;

public interface IProblemStatementReader {

    /**
     * @return String problem statement in one line
     * @throws Exception if the implementer can't retrieve the problem statement
     */
    String getProblemStatement() throws Exception;
}
