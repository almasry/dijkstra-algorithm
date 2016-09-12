package com.thoughtworks.trains.Utility.OutputHandler;

import java.util.concurrent.Callable;

public interface IOutputRenderer {

    /**
      * @param callableData a callable function
     *  @return IOutputRenderer object
     */
    IOutputRenderer renderOutput(Callable<Integer> callableData);
}
