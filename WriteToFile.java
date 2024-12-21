import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class WriteToFile {
    public static void writeResultToFile(String fileName, String output) {
        FileWriter writer = null;
        Formatter formatter = null;
        try {
            writer = new FileWriter(fileName, true);
            formatter = new Formatter(writer);
            formatter.format("%s", output);
            
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            if (formatter != null) {
                formatter.close();
            }
        }
    }
}
