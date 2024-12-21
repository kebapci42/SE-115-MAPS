public class Main {
    public static void main(String[] args){

        for(String arg : args){
            InputReader.readInputFile(arg);
            String[] cityNames = InputReader.createCityArray();
            String[][] routes = InputReader.createRouteArray();
            String[] question = InputReader.createQuestionArray();

            if (InputReader.isReadSuccesful) {
                CountryMap map = new CountryMap(cityNames, routes);
                
                if (map.isMappingSuccesful){
                    WayFinder.findFastestWay(map, question);

                    if (WayFinder.doesWayExist) {
                        WayFinder.printResult();
                    } else {
                        System.err.println(WayFinder.errorMessage);
                    }
                } else {
                    System.err.println(map.errorMessage);
                } 
            } else {
                System.err.println(InputReader.errorMessage);
            }
        }
    }
}
