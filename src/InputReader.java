import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputReader {
    public static String[] document;
    private static String[] cityNames;
    private static String[][] routes;
    private static String[] question;
    public static boolean isReadSuccesful = true;
    public static String errorMessage = "";

    public static void readInputFile(String fileName){

        Scanner reader = null;
        
        try {

            reader = new Scanner(Paths.get("../Maps", fileName));
            
            // Find the length of the document
            int lineCount = 0;

            while (reader.hasNextLine()) {
                reader.nextLine();
                lineCount++;
            }

            // Close and reopen the scanner to read the file again
            reader.close();
            reader = new Scanner(Paths.get("../Maps", fileName));

            // Fill the document array
            document = new String[lineCount];

            for (int i = 0; i < document.length; i++){
                document[i] = reader.nextLine().trim();
            }
        } catch (IOException e) {
            errorMessage = "Could not found the file " + fileName + "!";
            isReadSuccesful = false;
        } finally {
            if (reader != null){
                reader.close();
            }
        }
    }

    public static String[] createCityArray() {
        try {
            // Parse the size of the city array from the first line
            cityNames = new String[Integer.parseInt(document[0])];

            // Read the second line into the city array
            String[] cityInput = document[1].split(" ");

            if (cityNames.length != cityInput.length) { // Check for length
                errorMessage = "Number of cities does not satisfy the given size! Input File Error Line: 2";
                isReadSuccesful = false;
            } else {
                System.arraycopy(cityInput, 0, cityNames, 0, cityNames.length);
            }   
        } catch (NumberFormatException e) {
            errorMessage = "Could not parse the integer! Input File Error Line: 1";
            isReadSuccesful = false;
        }
        
        return cityNames;
    }

    public static String[][] createRoutesArray() {
        try {
            // Parse the size of the routes array from the third line and double it
            int size = Integer.parseInt(document[2]);
            routes = new String[size * 2][3]; // City1, City2, Time for every route
    
            // Fill the routes array in the given directions
            for(int i = 0; i < (routes.length / 2); i++){
                String[] routeInput = document[i + 3].split(" ");

                if (routeInput.length != 3) { // Check: City1, City2, Time for every route
                    errorMessage = "Number of elements for route " + (i + 1) + " is not true! Input File Error Line: " + (i + 4);
                    isReadSuccesful = false;
                } else {
                    System.arraycopy(routeInput, 0, routes[i], 0, 3);
                }    
            }

            if (isReadSuccesful) {
                // Make all the routes bidirectional
                for (int i = 0; i < (routes.length / 2); i++) {
                    String[] routeInput = document[i + 3].split(" ");
                    routes[i + size][0] = routeInput[1];
                    routes[i + size][1] = routeInput[0];
                    routes[i + size][2] = routeInput[2];
                }
            }
        } catch (NumberFormatException e) {
            errorMessage = "Could not parse the integer! Input File Error Line: 3";
            isReadSuccesful = false;
        }

        return routes;
    }

    public static String[] createQuestionArray() {
        // Read the last line into the question array
        String[] questionInput = document[document.length - 1].split(" "); 
        question = new String[2]; // Starting city and ending city

        if (questionInput.length != question.length) {
            errorMessage = "Could not found the question! Input File Error Line: " + (document.length);
            isReadSuccesful = false;
        } else {
            System.arraycopy(questionInput, 0, question, 0, question.length);
        }
        
        return question;
    }
}
