package com.thoughtworks.trains.Utility;

import com.thoughtworks.trains.Exception.InvalidInputReadingException;

public interface IProblemStatementReader {

    /**
     * @return String problem statement in one line
     * @throws InvalidInputReadingException if the implementer can't retrieve the problem statement
     */
    String getProblemStatement() throws InvalidInputReadingException;
}
