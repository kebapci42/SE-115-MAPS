import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputReader {
    public static String[] document;
    private static String[] cityNames;
    private static String[][] routes;
    private static String[] question;

    public static void readInputFile(String fileName){

        Scanner reader = null;
        
        try {
            
            reader = new Scanner(Paths.get(fileName));
            
            // Find the length of the document
            int lineCount = 0;

            while (reader.hasNextLine()) {
                reader.nextLine();
                lineCount++;
            }

            // CLose and reopen the scanner to read the file again
            reader.close();
            reader = new Scanner(Paths.get(fileName));

            // Fill the document array
            document = new String[lineCount];

            for (int i = 0; i < document.length; i++){
                document[i] = reader.nextLine().trim();
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

    public static String[] createCityArray() {
        // Parse the size of the city array from the first line
        cityNames = new String[Integer.parseInt(document[0])];

        // Read the second line into the city array
        System.arraycopy(document[1].split(" "), 0, cityNames, 0, cityNames.length);

        return cityNames;
    }

    public static String[][] createRouteArray() {
        // Parse the size of the route array from the third line
        routes = new String[Integer.parseInt(document[2])][3]; // City1, City2, Time for every route

        // Fill the routes array
        for(int i = 0; i < routes.length; i++){
            System.arraycopy(document[i + 3].split(" "), 0, routes[i], 0, 3);
        }

        return routes;
    }

    public static String[] createQuestionArray() {
        // Read the last line into the question array
        question = new String[2]; // Starting city and ending city
        System.arraycopy(document[document.length - 1].split(" "), 0, question, 0, question.length);

        return question;
    }
}
