import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search (assumes sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 2); // random within a wider range
        return arr;
    }

    // Run and time both searches
    public static void compareSearches(int size, int target) {
        int[] arr = generateRandomArray(size);

        // Linear Search
        long start = System.nanoTime();
        linearSearch(arr, target);
        long linearTime = System.nanoTime() - start;

        // Sort the array before Binary Search
        Arrays.sort(arr);
        start = System.nanoTime();
        binarySearch(arr, target);
        long binaryTime = System.nanoTime() - start;

        // Results
        System.out.printf("Dataset Size: %,d\n", size);
        System.out.printf("Linear Search Time: %.3f ms\n", linearTime / 1e6);
        System.out.printf("Binary Search Time: %.3f ms\n", binaryTime / 1e6);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Performance Comparison: Linear vs Binary Search\n");

        compareSearches(1_000, -1);       // unlikely to be found
        compareSearches(10_000, -1);
        compareSearches(1_000_000, -1);
    }
}
