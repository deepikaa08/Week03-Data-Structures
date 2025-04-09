import java.util.Scanner;

public class CountingSort{

    // Method to perform Counting Sort
    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int minAge = 10;

        // Create a count array to store the frequency of each age
        int range = maxAge - minAge + 1;
        int[] count = new int[range];

        // Count the occurrences of each age
        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - minAge]++;
        }

        // Compute cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Create an output array to store sorted ages
        int[] output = new int[ages.length];

        // Place elements in their correct position in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy the sorted ages back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] studentAges = new int[n];

        // Input student ages
        System.out.println("Enter the ages of the students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            studentAges[i] = scanner.nextInt();
        }

        // Sort using Counting Sort
        countingSort(studentAges);

        // Output sorted ages
        System.out.println("Sorted student ages in ascending order:");
        for (int age : studentAges) {
            System.out.print(age + " ");
        }

        scanner.close();
    }
}
