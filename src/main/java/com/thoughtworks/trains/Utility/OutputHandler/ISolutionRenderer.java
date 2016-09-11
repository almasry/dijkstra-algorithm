package com.thoughtworks.trains.Utility.OutputHandler;

import java.util.concurrent.Callable;

public interface ISolutionRenderer {

    /**
     * @throws Exception if the implementer can't retrieve the problem statement
     */
    ISolutionRenderer renderOutput(Callable<Integer> callableData);
}
