public class CountryMap {
    public City[] unvisitedCities;
    public City[] visitedCities;
    public City currentCity;
    public boolean isMappingSuccesful = true;
    public String errorMessage = "";

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
        // Check for miswritten question
        if (currentCity == null) {
            errorMessage = "Starting city does not exist among the given city list! Input File Error Line: " + (InputReader.document.length);
            isMappingSuccesful = false;
        }

        if (isMappingSuccesful){
            // Main loop to process cities
            while (currentCity != null) {
                // Iterate over the routes array to find all neighbours of current city
                for (int i = 0; i < routes.length; i++) {
                    // Find a route that starts from current city
                    if (currentCity.getName().equals(routes[i][0])) {

                        for (City city : unvisitedCities) {
                            // Find the end city for the same route
                            if (city.getName().equals(routes[i][1])) {

                                double newTime;
                                try {
                                    newTime = Double.parseDouble(routes[i][2]);// Parse the time of the route
                                    
                                    if (currentCity.getTime() + newTime < city.getTime()) {
                                        city.setTime(currentCity.getTime() + newTime);
                                        city.setPreviousCity(currentCity);
                                    }

                                } catch (NumberFormatException e) {
                                    errorMessage = "Could not parse the time for the route" + (i + 1) + "! Input File Error Line: " + (i + 4);
                                    isMappingSuccesful = false;
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
