
public class Main {
    public static void main(String[] args){
        for(String arg : args){
            InputReader.readInputFile(arg);
            
            CountryMap map = new CountryMap(InputReader.createCityArray(), InputReader.createRouteArray());
            for (City city : map.visitedCities) {
                if (city.getTime() < Double.POSITIVE_INFINITY && city.getTime() > 0) {
                    System.out.println(city.getName() + "\t" + city.getTime() + "\t" + city.getPreviousCity().getName());
                }
            }
            
        }
    }
}
