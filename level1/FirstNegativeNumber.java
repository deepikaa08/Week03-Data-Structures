public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] numbers = {10, 3, 5, 0, -2, 7, -9}; // Sample array
        
        int index = findFirstNegativeIndex(numbers);
        
        if (index != -1) {
            System.out.println("First negative number is at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    // Method to perform linear search for the first negative number
    public static int findFirstNegativeIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // return index of first negative number
            }
        }
        return -1; // if no negative number is found
    }
}
