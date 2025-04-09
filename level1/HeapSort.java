import java.util.Scanner;

public class HeapSort {

    // Method to perform Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 1; i--) {
            // Swap the root (maximum element) with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to heapify a subtree rooted at index i
    public static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of job applications
        System.out.print("Enter the number of job applications: ");
        int n = scanner.nextInt();
        int[] salaryDemands = new int[n];

        // Input salary demands
        System.out.println("Enter the salary demands of the applicants:");
        for (int i = 0; i < n; i++) {
            salaryDemands[i] = scanner.nextInt();
        }

        // Sort using Heap Sort
        heapSort(salaryDemands);

        // Output sorted salary demands
        System.out.println("Sorted salary demands in ascending order:");
        for (int salary : salaryDemands) {
            System.out.print(salary + " ");
        }

        scanner.close();
    }
}
