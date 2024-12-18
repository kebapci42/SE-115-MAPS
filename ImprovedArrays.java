public class ImprovedArrays {
    public static City[] addStringElementToArray(City[] oldArray, City newValue) {

        City[] newArray = new City[oldArray.length + 1];

        // Copy all existing elements to new array
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);

        // Add new value to the last index of new array
        newArray[newArray.length - 1] = newValue;

        return newArray;
    }

    public static City[] addCityElementToArray(City[] oldArray, City newCity) {

        City[] newArray = new City[oldArray.length + 1];

        // Copy all existing elements to new array
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        
        // Add new value to the last index of new array
        newArray[newArray.length - 1] = newCity;

        return newArray;
    }

    public static City[] removeCityElementFromArray(City[] oldArray, City oldCity) {
        City[] newArray = new City[oldArray.length - 1];
        int index = 0;

        for (City city : oldArray) {
            if (!city.equals(oldCity)) {
                newArray[index++] = city; // Add element, then increment by 1
            }
        }

        return newArray;
    }
}
