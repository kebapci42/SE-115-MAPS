public class Main {
    public static void main(String[] args){

        for(String arg : args){
            String fileName = arg + ".txt";

            InputReader.readInputFile(fileName);
            String[] cityNames = InputReader.createCityArray();
            String[][] routes = InputReader.createRoutesArray();
            String[] question = InputReader.createQuestionArray();

            if (InputReader.isReadSuccesful) {
                System.out.println("File read is succesful!");
                CountryMap map = new CountryMap(cityNames, routes);
                
                if (map.isMappingSuccesful){
                    WayFinder.findFastestWay(map, question);

                    if (WayFinder.doesWayExist) {
                        WayFinder.printResult(arg);
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
