import java.util.*;

public class Main {
    public static void main(String[] args){
        for(String arg : args){
            InputReader.readInputFile(arg);
            System.out.println(Arrays.toString(InputReader.document));
            
        }
    }
}
