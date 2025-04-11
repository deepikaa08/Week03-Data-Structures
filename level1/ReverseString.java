public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }

    public static String reverseString(String str) {
        // Create a new StringBuilder object
        StringBuilder stringBuilder = new StringBuilder();
        
        // Append the string to the StringBuilder
        stringBuilder.append(str);
        
        // Use the reverse() method to reverse the string
        stringBuilder.reverse();
        
        // Convert the StringBuilder back to a string and return it
        return stringBuilder.toString();
    }
}
