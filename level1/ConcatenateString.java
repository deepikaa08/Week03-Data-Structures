public class ConcatenateString{
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "world", "!", " ", "How", " ", "are", " ", "you?"};
        String result = concatenateStrings(strings);
        System.out.println("Concatenated String: " + result);
    }

    public static String concatenateStrings(String[] arr) {
        // Create a new StringBuffer object
        StringBuffer stringBuffer = new StringBuffer();
        
        // Iterate through each string in the array and append it to the StringBuffer
        for (String str : arr) {
            stringBuffer.append(str);
        }
        
        // Return the concatenated string after the loop finishes
        return stringBuffer.toString();
    }
}
