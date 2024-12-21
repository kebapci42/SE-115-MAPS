public class WayFinder {
    private static City startCity = null;
    private static City endCity = null;
    private static City[] resultantRoute = new City[0];
    public static boolean doesWayExist = true;
    public static String errorMessage = "";

    public static void findFastestWay(CountryMap map, String[] question) {

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

        // Check for miswritten question
        if (endCity == null) {
            errorMessage = "Ending city does not exist among the given city list! Input File Error Line: " + (InputReader.document.length);
            doesWayExist = false;
        }
        
        if (doesWayExist) {
            // Read all the previous cities into array from end to start
            City tempCity;

            try {
                while ((tempCity = ImprovedArrays.getLastCityElementOfArray(resultantRoute)) != startCity) {
                    resultantRoute = ImprovedArrays.addCityElementToArray(resultantRoute, tempCity.getPreviousCity());
                } 
            } catch (NullPointerException e) {
                errorMessage = "No such way exists between start and end cities!";
                doesWayExist = false;
            }
        }
    }
    
    public static void printResult(String fileName) {
        String fastestRoute = "";
        double totalTime = ImprovedArrays.getFirstCityElementOfArray(resultantRoute).getTime();

        for (int i = resultantRoute.length - 1; i >= 0; i--) {
            fastestRoute += resultantRoute[i].getName() + " --> ";
        }

        String output = "\nFastest Way: " + fastestRoute.substring(0, fastestRoute.length() - 5) + 
                        "\nTotal Time: " + totalTime + " mins.\n";
        
        fileName = fileName + "Result.txt";
        WriteToFile.writeResultToFile(fileName, output);
    }
}
