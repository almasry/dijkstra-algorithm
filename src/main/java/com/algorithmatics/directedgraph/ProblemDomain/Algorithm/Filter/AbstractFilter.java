package com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Filter;

import com.algorithmatics.directedgraph.ProblemDomain.Algorithm.Route;

public abstract class AbstractFilter {

    public enum Operator   { EQUAL, EQUAL_ORL_ESS, EQUAL_OR_MORE, LESS_THAN, MORE_THAN }

    public enum FilterType { DEFAULT, ROUTE_LENGTH, NUMBER_OF_STOPS }

    int filterValue = 0;

    FilterType filterType;

    Operator operator;

    /**
     * @return true if the filer applied successfully, false otherwise
     */
    boolean applyFilter(int routeConditionValue){

        boolean condition = false;

        switch (operator)
        {
            case EQUAL:
                condition = (routeConditionValue == filterValue);
                break;

            case EQUAL_ORL_ESS:
                condition = !(routeConditionValue <= filterValue);
                break;

            case EQUAL_OR_MORE:
                condition = !(routeConditionValue >= filterValue);
                break;

            case LESS_THAN:
                condition = !(routeConditionValue < filterValue);
                break;

            case MORE_THAN:
                condition = !(routeConditionValue > filterValue);
                break;
        }

        return condition;
    }

    /**
     * @return true if the filter applies, false otherwise
     */
    public abstract boolean apply(Route route);

    /**
     * @return Type of the filter used
     */
    public FilterType getFilterType() {
        return  filterType;
    }
}
