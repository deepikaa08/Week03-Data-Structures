import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertByteStream {
    public static void main(String[] args) {
        // Specify the file path (update the path as per your file location)
        String filePath = "example.txt";
        
        // Specify the charset for decoding (UTF-8 in this case)
        String charset = "UTF-8";
        
        // Initialize InputStreamReader and BufferedReader
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            
            String line;
            
            // Read each line from the file and print it as characters
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            // Handle potential IOException, such as file not found or encoding issues
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
