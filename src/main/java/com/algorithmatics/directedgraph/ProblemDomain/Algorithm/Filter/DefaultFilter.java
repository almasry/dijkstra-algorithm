package com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Filter;

import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Route;

public class DefaultFilter extends AbstractFilter {

    private FilterType filterType ;

    public DefaultFilter()
    {
        this.filterType = FilterType.DEFAULT;
    }

    /**
     * {@inheritDoc}
     */
    public FilterType getFilterType() {
        return  filterType;
    }

    /**
     * {@inheritDoc}
     */
    public boolean apply(Route route) {
        return  true;
    }

}
