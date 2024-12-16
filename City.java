public class City {
    public String name;
    public double time;
    public City previousCity;

    public City(String name, double time) {
        this.name = name;
        this.time = time;
        this.previousCity = null;
    }

    //
    public String getName() {
        return this.name;
    }

    // Getter and setter for time
    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    // Getter and setter for previous city
    public City getPreviousCity() {
        return this.previousCity;
    }
    public void setPreviousCity(City previousCity) {
        this.previousCity = previousCity;
    }
}
