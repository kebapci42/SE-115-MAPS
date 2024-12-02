import java.io.*;
import java.util.*;

public class InputReader {
    public String[] cities;
    public String[][] routes;

    public InputReader(File file) throws FileNotFoundException, IOException{
        ArrayList<String> document = splitDoc(file);
        cities = findCities(document);
        routes = findRoutes(document);
    } 

    // Read the file content into an ArrayList
    public static ArrayList<String> splitDoc(File file) throws IOException {
        ArrayList<String> document = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                document.add(line);
            }
        }
        return document;
    }

    // Parse cities from the second line of the document
    public static String[] findCities(ArrayList<String> document){
        return document.get(1).split(" ");
    }

    // Parse routes from the pre-read document
    public static String[][] findRoutes(ArrayList<String> document) {
        int size = Integer.parseInt(document.get(2)); // Third line of the document
        String[][] routes = new String[size][3];// Format of the route is City1 City2 Time

        for (int i = 0; i < size; i++) {
            routes[i] = document.get(i + 3).split(" "); // Start parsing from the 4th line
        }

        return routes;
    }

    // Parse question from the last line of the document
    public static String[] question(ArrayList<String> document){
        return document.getLast().split(" ");
    }
}
