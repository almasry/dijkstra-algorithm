package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.ProblemDomain.Entity.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

class Graph {

    private Map<String, Route> routesMap = new HashMap<>();

    /**
     * @param citiesStack the cities in the stack which are used to form the route
     * @param endCity the city at he end of the route
     * @param sourceCity the city where the route started at
     * @param distanceFromSource the distance of the current city from the source city
     */
    void registerRoute(Stack<City> citiesStack , City endCity, City sourceCity, int distanceFromSource)
    {
        ArrayList<City> routeCities = new ArrayList<>(citiesStack);

        routeCities.add(endCity);

        String routeName = getRouteName(routeCities);

        Route route = new Route(sourceCity, endCity, distanceFromSource, citiesStack.size());

        this.routesMap.put(routeName, route);
    }

    /**
     * @param cities list of the cities that form the route
     * @return route that matches the cities on the route
     */
    Route findRoute(ArrayList<City> cities)
    {
        String routeName = this.getRouteName(cities);

        return this.getRouteMap().get(routeName);
    }

    /**
     * @return map of the discovered routes
     */
    Map<String, Route> getRouteMap()
    {
        return routesMap;
    }

    /**
     * @param cities cities that are on the route
     * @return string representation of the route separated with dashes (A-B-C-D)
     */
    private String getRouteName(ArrayList<City> cities)
    {
        return cities
                .stream()
                .map(City::getCityName)
                .collect(Collectors.joining("-"));
    }
}
