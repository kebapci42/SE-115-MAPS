public class Way {
    private int time;
    private City startCity;
    private City endCity;

    //Constructors
    public Way(){
        time = 0;
        startCity = null;
        endCity = null;
    }

    public Way(City startCity, City endCity, int time){
        this.startCity = startCity;
        this.endCity = endCity;
        this.time = time;
    }

    // StartCity getter and setter
    public City getStartCity(){
        return this.startCity;
    }

    public void setStartCity(City startCity){
        this.startCity = startCity;
    }

    // EndCity getter and setter
    public City getEndCity(){
        return this.endCity;
    }

    public void setEndcity(City endCity){
        this.endCity = endCity;
    }

    // Time getter and setter
    public int getTime(){
        return this.time;
    }

    public void setTime(int time){
        this.time = time;
    }

    // Parse routes from strings to an array of ways
    public static Way[] createWayArray(String[][] ways){
        Way[] routes = new Way[ways.length];

        for (int i = 0; i < routes.length; i++) {

            String start = ways[i][0];
            String end = ways[i][1];
            int time = Integer.parseInt(ways[i][2]);

            Way route = new Way(new City(start), new City(end), time);

            routes[i] = route;
        }

        return routes;
    }
}
