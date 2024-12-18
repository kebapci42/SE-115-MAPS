public class WayFinder {
    public static void findFastestWay(CountryMap map, String[] question) {

        City startCity = null;
        City endCity;
        City[] resultantRoute = new City[0];

        for (City city : map.visitedCities) {
            // Find startCity
            if (city.getName().equalsIgnoreCase(question[0])) {
                startCity = city;
            }

            // Find endCity
            if (city.getName().equalsIgnoreCase(question[1])) {
                endCity = city;
                resultantRoute = ImprovedArrays.addCityElementToArray(resultantRoute, endCity);
            }
        }
        
        // Read all the previous cities into array from end to start
        City tempCity;
        while ((tempCity = ImprovedArrays.getLastCityElementOfArray(resultantRoute)) != startCity) {
            resultantRoute = ImprovedArrays.addCityElementToArray(resultantRoute, tempCity.getPreviousCity());
        }
        
        // Print the result
        String output = "";
        double totalTime = ImprovedArrays.getFirstCityElementOfArray(resultantRoute).getTime();
        for (int i = resultantRoute.length - 1; i >= 0; i--) {
            output += resultantRoute[i].getName() + " --> ";
        }
        System.out.println(output.substring(0, output.length() - 5) + "\t" + totalTime + " mins");
    }
}
