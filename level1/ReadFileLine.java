import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLine {
    public static void main(String[] args) {
        // Specify the file path (update the path as per your file location)
        String filePath = "example.txt";
        
        // Initialize FileReader and BufferedReader
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            
            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Print the current line to the console
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle potential IOException
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
