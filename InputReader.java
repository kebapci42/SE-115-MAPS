import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputReader {
    public static String[] cities;
    public static String[] routes;

    public static void readInputFile(String fileName){

        Scanner reader = null;

        try {
            
            reader = new Scanner(Paths.get(fileName));
            
            String line;
            for(int lineNumber = 0; reader.hasNextLine(); lineNumber++){

                line = reader.nextLine();

                // Parse the size of city array
                if (lineNumber == 0) {
                    cities = City.createCityArray(Integer.parseInt(line));
                }

                // Fill the city array
                if (lineNumber == 1) {
                    System.arraycopy(line.trim().split(" "), 0, cities, 0, cities.length);
                }
            }

        } catch (IOException e) {
            System.out.printf("Could not found the file '%s'.", fileName);
        } catch (NumberFormatException e) {

        } finally {
            if (reader != null){
                reader.close();
            }
        }
    }
}
