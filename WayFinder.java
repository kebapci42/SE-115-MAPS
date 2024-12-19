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

        if (startCity == null) {
            errorMessage = "Starting city does not exist among the given city list!" + 
                        " Input File Error Line: " + (InputReader.document.length);
            doesWayExist = false;
        }
        if (endCity == null) {
            errorMessage = "Ending city does not exist among the given city list!" + 
                        " Input File Error Line: " + (InputReader.document.length);
            doesWayExist = false;
        }
        
        if (doesWayExist) {
            // Read all the previous cities into array from end to start
            City tempCity;

            while ((tempCity = ImprovedArrays.getLastCityElementOfArray(resultantRoute)) != startCity) {
                resultantRoute = ImprovedArrays.addCityElementToArray(resultantRoute, tempCity.getPreviousCity());
            }
        }
            
    }
    
    public static void printResult() {
        String output = "";
        double totalTime = ImprovedArrays.getFirstCityElementOfArray(resultantRoute).getTime();
        for (int i = resultantRoute.length - 1; i >= 0; i--) {
            output += resultantRoute[i].getName() + " --> ";
        }
        System.out.println( "Fastest Way: " + output.substring(0, output.length() - 5) + 
                            "\nTotal Time: " + totalTime + " mins.");
    }
}
