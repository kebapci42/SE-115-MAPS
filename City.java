public class City {
    private String name;

    public City(String name){
        this.name = name;
    }

    // Name getter and Setter
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    // Parse city names to create an array of cities
    public static City[] createCityArray(String[] cityNames){
        City[] cities = new City[cityNames.length];

        for(int i = 0; i < cities.length; i++){
            cities[i] = new City(cityNames[i]);
        }

        return cities;
    }
}
