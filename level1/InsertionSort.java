import java.util.Scanner;

public class InsertionSort {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i]; // Current element to be inserted
            int j = i - 1;

            // Move elements of ids[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            ids[j + 1] = key; // Insert the key at its correct position
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of employees
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        int[] employeeIDs = new int[n];

        // Input employee IDs
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = scanner.nextInt();
        }

        // Sort using Insertion Sort
        insertionSort(employeeIDs);

        // Output sorted employee IDs
        System.out.println("Sorted employee IDs in ascending order:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }

        scanner.close();
    }
}
