public class CountryMap {
    public City[] unvisitedCities;
    public City[] visitedCities;
    public City currentCity;

    public CountryMap(String[] cityNames, String[][] routes){
        // Initialize both city arrays
        unvisitedCities = new City[cityNames.length];
        visitedCities = new City[0];

        // Mark all the cities as unvisited
        for (int i = 0; i < cityNames.length; i++) {
            unvisitedCities[i] = new City(cityNames[i], Double.POSITIVE_INFINITY);
        }

        // Specify the starting city
        for (City city : unvisitedCities){
            if (city.getName().equalsIgnoreCase(InputReader.createQuestionArray()[0])) {
                city.setTime(0);
                currentCity = city;
            }
        }

        // Main loop to process cities
        while (currentCity != null) {
            // Iterate over the routes array to find all neighbours of current city
            for (String[] route : routes) {
                // Find a route that starts from current city
                if (currentCity.getName().equals(route[0])) {

                    for (City city : unvisitedCities) {
                        // Find the end city for the same route
                        if (city.getName().equals(route[1])) {

                            double newTime = Double.parseDouble(route[2]);// Parse the time of the route

                            if (currentCity.getTime() + newTime < city.getTime()) {
                                city.setTime(currentCity.getTime() + newTime);
                                city.setPreviousCity(currentCity);
                            }
                        }
                    }
                }
            }

            // Mark current city as visited
            visitedCities = ImprovedArrays.addCityElementToArray(visitedCities, currentCity);

            // Remove current city from the unvisited cities
            unvisitedCities = ImprovedArrays.removeCityElementFromArray(unvisitedCities, currentCity);

            // Choose a new current city from the unvisited cities
            currentCity = getNextCityWithSmallestTime();
        }

    }

    public City getNextCityWithSmallestTime() {
        City nextCity = null;
        double smallestTime = Double.POSITIVE_INFINITY;

        for (City city : unvisitedCities) {
            if (city.getTime() < smallestTime) {
                smallestTime = city.getTime();
                nextCity = city;
            }
        }

        return nextCity;
    }
}
