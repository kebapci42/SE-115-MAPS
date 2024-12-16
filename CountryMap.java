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
                if (currentCity.getName().equalsIgnoreCase(route[0])) {
                    for (City city : unvisitedCities) {
                        if (city.getName().equalsIgnoreCase(route[1])) {
                            double newTime = Double.parseDouble(route[2]);
                            if (newTime < city.getTime()) {
                                city.setTime(newTime);
                                city.setPreviousCity(currentCity);
                            }
                        }
                    }
                }
            }

            // Mark current city as visited
            addCurrentCityToVisitedCities();

            // Remove current city from the unvisited cities
            removeCurrentCityFromUnvisitedCities();

            // Choose a new current city from the unvisited cities
            currentCity = getNextCityWithSmallestTime();
        }

    }

    public void addCurrentCityToVisitedCities() {
        City[] updatedVisitedCities = new City[visitedCities.length + 1];

        // Copy existing elements to new array
        System.arraycopy(visitedCities, 0, updatedVisitedCities, 0, visitedCities.length);

        // Add current city to the last slot
        updatedVisitedCities[visitedCities.length] = currentCity;

        // Update visited cities
        visitedCities = updatedVisitedCities;
    }

    public void removeCurrentCityFromUnvisitedCities() {
        City[] updatedUnvisitedCities = new City[unvisitedCities.length - 1];
        int index = 0;

        for (City city : unvisitedCities) {
            if (!city.equals(currentCity)) {
                updatedUnvisitedCities[index++] = city;// Add city and then increment index by 1
            }
        }

        unvisitedCities = updatedUnvisitedCities;
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
