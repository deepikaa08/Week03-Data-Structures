import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OccurenceCount {
    public static void main(String[] args) {
        // Specify the file path (update the path as per your file location)
        String filePath = "example.txt";
        
        // Specify the word to search for
        String targetWord = "hello";
        
        // Initialize the counter for word occurrences
        int wordCount = 0;
        
        // Initialize FileReader and BufferedReader
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line;
            
            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words based on spaces
                String[] words = line.split("\\s+");
                
                // Count occurrences of the target word in the current line
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }
            
            // Print the total count of occurrences
            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
            
        } catch (IOException e) {
            // Handle potential IOException
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
