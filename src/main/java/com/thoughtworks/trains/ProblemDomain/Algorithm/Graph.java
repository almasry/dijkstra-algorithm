package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.ProblemDomain.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

class Graph {

    private Map<String, Route> routesList = new HashMap<>();

    /**
     * @param citiesStack
     * @param endCity
     * @param sourceCity
     * @param distanceFromSource
     */
    void registerRoute(Stack<City> citiesStack , City endCity, City sourceCity, int distanceFromSource)
    {
        ArrayList<City> routeCities = new ArrayList<>(citiesStack);

        routeCities.add(endCity);

        String routeName = getRouteName(routeCities);

        Route route = new Route(sourceCity, endCity, distanceFromSource, citiesStack.size());

        this.routesList.put(routeName, route);
    }

    /**
     * @param cities
     * @return
     */
    Route findRoute(ArrayList<City> cities)
    {
        String routeName = this.getRouteName(cities);

        return this.getRoutesList().get(routeName);
    }

    /**
     * @return
     */
    Map<String, Route> getRoutesList()
    {
        return routesList;
    }

    /**
     * @param cities
     * @return
     */
    private String getRouteName(ArrayList<City> cities)
    {
        return cities
                .stream()
                .map(City::getCityName)
                .collect(Collectors.joining("-"));
    }
}
