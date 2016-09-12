package com.thoughtworks.trains.ProblemDomain.Algorithm;

import com.thoughtworks.trains.Exception.RouteNotFoundException;
import com.thoughtworks.trains.ProblemDomain.Algorithm.Filter.DefaultFilter;
import com.thoughtworks.trains.ProblemDomain.Algorithm.Filter.AbstractFilter;
import com.thoughtworks.trains.ProblemDomain.Entity.City;
import com.thoughtworks.trains.ProblemDomain.Entity.Edge;
import com.thoughtworks.trains.ProblemDomain.Respository.CityRepository;
import com.thoughtworks.trains.ProblemDomain.Respository.EdgeRepository;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * DijkstraAlgorithm Algorithm is mainly used to find the shortest route between two points on a graph
 * See <a href="https://www.youtube.com/watch?v=2E7MmKv0Y24"> MIT professor explaining Dijkstra's Algorithm </a>
 */
public class DijkstraAlgorithm implements ITrainsAlgorithm {

    private EdgeRepository edgeRepository;

    private CityRepository cityRepository;

    private Graph graph = new Graph();

    private Stack<City> citiesStack = new Stack<>();

    /**
     * @param edgeRepository repository of all the edges extracted from the problem statement
     * @param cityRepository repository of all the cities extracted from the problem statement
     */
    public DijkstraAlgorithm(EdgeRepository edgeRepository, CityRepository cityRepository)
    {
        this.edgeRepository = edgeRepository;

        this.cityRepository = cityRepository;
    }

    /**
     * {@inheritDoc}
     */
    public int findLengthOfRoute(ArrayList<String> cityNames) throws RouteNotFoundException
    {
        ArrayList<City> routeCities = cityNames
                                        .stream()
                                        .map(city -> this.cityRepository.getCityByName(city))
                                        .collect(Collectors.toCollection(ArrayList::new));

        discoverGraphAtSourceCity(routeCities.get(0), new DefaultFilter());

        Route route = this.graph.findRoute(routeCities);

        if((route == null ))
        {
            throw new RouteNotFoundException("NO SUCH ROUTE");
        }

        return  route.getLength();
    }

    /**
     * {@inheritDoc}
     */
    public int findLengthOfShortestRoute(String nameOfStartCity, String nameOfEndCity) throws RouteNotFoundException
    {
        try {

            City startCity  = this.cityRepository.getCityByName(nameOfStartCity);
            City endCity    = this.cityRepository.getCityByName(nameOfEndCity);

            discoverGraphAtSourceCity(startCity, new DefaultFilter());

            Route shortestRoute = null;

            for(Map.Entry<String, Route> entry : this.graph.getRouteMap().entrySet())
            {
                Route route = entry.getValue();

                if(route.getStart().equals(startCity) &&  route.getEnd().equals(endCity) )
                {
                    if((shortestRoute == null)  || (route.getLength() < shortestRoute.getLength()))
                    {
                        shortestRoute = route;
                    }
                }
            }
            if(shortestRoute == null){
                throw new RouteNotFoundException("NO SUCH ROUTE");
            }
            return shortestRoute.getLength();

        }catch (Exception e){
            throw new RouteNotFoundException("NO SUCH ROUTE");
        }
    }

    /**
     * {@inheritDoc}
     */
    public int findNumberOfTrips(
            String nameOfStartCity,
            String nameOfEndCity,
            AbstractFilter filter
    ) throws RouteNotFoundException
    {
        try {

            City startCity  = this.cityRepository.getCityByName(nameOfStartCity);
            City endCity    = this.cityRepository.getCityByName(nameOfEndCity);

            return findAllPossibleRoutesBetweenTwoCities(startCity,endCity,filter)
                    .size();

        } catch (Exception e) {

            throw new RouteNotFoundException("NO SUCH ROUTE");
        }
    }

    /**
     * @param startCity city where the route (trip) discovery should start from
     * @param endCity city where the route (trip) discovery should end at
     * @param filter the filter of the operation
     * @return list of all possible trips between the start and end cities
     */
    private ArrayList<Route> findAllPossibleRoutesBetweenTwoCities(City startCity, City endCity, AbstractFilter filter)
    {
        discoverGraphAtSourceCity(startCity, filter);

        ArrayList<Route> routes = new ArrayList<>();

        for(Map.Entry<String, Route> entry : this.graph.getRouteMap().entrySet())
        {
            Route route = entry.getValue();

            if(route.getStart().equals(startCity) &&  route.getEnd().equals(endCity) && (!filter.apply(route)))
            {
                routes.add(route);
            }
        }
        return routes;
    }

    /**
     * @param city source city to start the path discovery from
     * @param filter algorithm filter on length and number of sops
     */
    private void discoverGraphAtSourceCity(City city, AbstractFilter filter)
    {
        this.traversePath(city, city, 0, filter);
    }

    /***
     * @param currentCity at which the route will start discovering (the city at the beginning of a sub route )
     * @param sourceCity the source city from which the whole route discovery started
     * @param distanceFromSource distance of the current city from the source city
     * @param filter algorithm filter on length and number of sops
     */
    private void traversePath(City currentCity, City sourceCity, int distanceFromSource, AbstractFilter filter)
    {
        this.citiesStack.push(currentCity);

        // getting all edges that start with this city to dig them down $$
        ArrayList<Edge> edgesFromCurrentCity = this.edgeRepository.fetchByStartCity(currentCity);

        for (Edge edge : edgesFromCurrentCity) {

            int routeLength = distanceFromSource + edge.getEdgeLength();

            City nextCity = cityRepository.getCityByName(edge.getEnd().getCityName());

            // Register current route possible route
            Route route = this.graph.registerRoute(
                    this.citiesStack,
                    nextCity,
                    sourceCity,
                    routeLength
            );

            //Applying filters (if applicable )
            if(filter.getFilterType().equals(AbstractFilter.FilterType.DEFAULT))
            {
                if(!this.isCircularPath(nextCity))
                    this.traversePath(nextCity, sourceCity, routeLength, filter);
            }
            else
            {
                if (!filter.apply(route))
                    this.traversePath(nextCity, sourceCity, routeLength, filter);
            }
        }
        // popping the visited city from the stack as all its possible routes have been discovered
        this.citiesStack.pop();
    }

    /**
     * @param city next city to visit
     * @return true if the city will lead to a circular path (eg: A-B-C-A-B-C), returns false otherwise
     */
    private boolean isCircularPath(City city)
    {
        for (City n : this.citiesStack){
            if(n.getCityName().equals(city.getCityName())){
                return true;
            }
        }
        return false;
    }
}