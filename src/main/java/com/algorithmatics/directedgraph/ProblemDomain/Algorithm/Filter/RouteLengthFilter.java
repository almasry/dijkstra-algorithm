package com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Filter;

import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Route;

public class RouteLengthFilter extends AbstractFilter {

    public RouteLengthFilter(Operator operator, int filterValue)
    {
        this.filterType = FilterType.ROUTE_LENGTH;
        this.filterValue = filterValue;
        this.operator = operator;
    }

    /**
     * {@inheritDoc}
     */
    public boolean apply(Route route){

        int numberOfStops = route.getLength();

        return super.applyFilter(numberOfStops);

    }

}
