import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        // Initialize an empty StringBuilder to store the result
        StringBuilder stringBuilder = new StringBuilder();
        
        // Initialize a HashSet to keep track of characters we have already seen
        HashSet<Character> seenCharacters = new HashSet<>();
        
        // Iterate over each character in the string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            
            // If the character is not in the HashSet, append it to the StringBuilder
            if (!seenCharacters.contains(currentChar)) {
                stringBuilder.append(currentChar);
                seenCharacters.add(currentChar); // Add the character to the HashSet
            }
        }
        
        // Return the StringBuilder as a string without duplicates
        return stringBuilder.toString();
    }
}
