import java.util.Scanner;

public class QuickSort{

    // Method to perform Quick Sort
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(prices, low, high);

            // Recursively sort the left and right partitions
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // Method to partition the array
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is less than or equal to pivot
            if (prices[j] <= pivot) {
                i++;

                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i+1] and pivot (prices[high])
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return pivot index
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of products
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();
        double[] productPrices = new double[n];

        // Input product prices
        System.out.println("Enter the prices of the products:");
        for (int i = 0; i < n; i++) {
            productPrices[i] = scanner.nextDouble();
        }

        // Sort using Quick Sort
        quickSort(productPrices, 0, n - 1);

        // Output sorted prices
        System.out.println("Sorted product prices in ascending order:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }

        scanner.close();
    }
}
