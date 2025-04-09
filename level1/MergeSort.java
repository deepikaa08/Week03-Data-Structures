import java.util.Scanner;

public class MergeSort {

    // Method to perform Merge Sort
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays
    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = prices[mid + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of books
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        double[] bookPrices = new double[n];

        // Input book prices
        System.out.println("Enter the prices of the books:");
        for (int i = 0; i < n; i++) {
            bookPrices[i] = scanner.nextDouble();
        }

        // Sort using Merge Sort
        mergeSort(bookPrices, 0, n - 1);

        // Output sorted book prices
        System.out.println("Sorted book prices in ascending order:");
        for (double price : bookPrices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }
}
