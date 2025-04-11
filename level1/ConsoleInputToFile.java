import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputToFile {
    public static void main(String[] args) {
        // File path where input will be written
        String filePath = "user_input.txt";

        System.out.println("Enter text to write to the file. Type 'exit' to quit:");

        // Use InputStreamReader to read from System.in and wrap it with BufferedReader
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(filePath)) {

            String inputLine;

            // Read input until user types "exit"
            while (!(inputLine = reader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(inputLine + System.lineSeparator());
            }

            System.out.println("User input has been written to '" + filePath + "'.");

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing: " + e.getMessage());
        }
    }
}
