public class CountryMap {
    public static void main(String[] args){
        String[] cityNames = {"A", "B", "C", "D", "E"};
        City[] cities = City.createCityArray(cityNames);

        String[][] ways = {{"A", "B", "30"}, {"A", "C", "10"}, {"B", "D", "20"}, {"C", "D", "50"}, {"C", "E", "40"}, {"D", "E", "10"}};
        Way[] routes = Way.createWayArray(ways);

        
    }

    
}
