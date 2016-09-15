package com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Filter;

import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Route;

public class NumberOfStopsFilter extends AbstractFilter {

    public NumberOfStopsFilter(Operator operator, int filterValue)
    {
        this.filterType = FilterType.NUMBER_OF_STOPS;
        this.filterValue = filterValue;
        this.operator = operator;
    }

    /**
     * {@inheritDoc}
     */
    public boolean apply(Route route){

        int numberOfStops = route.getNumberOfStops();

        return super.applyFilter(numberOfStops);
    }
}
