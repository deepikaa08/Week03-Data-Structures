import java.util.Arrays;
import java.util.Random;

public class SortComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 2); // random within a wider range
        return arr;
    }

    // Run and time all three sorts
    public static void compareSorts(int size) {
        int[] arr1 = generateRandomArray(size);
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);

        // Bubble Sort
        long start = System.nanoTime();
        bubbleSort(arr1);
        long bubbleTime = System.nanoTime() - start;

        // Merge Sort
        start = System.nanoTime();
        mergeSort(arr2);
        long mergeTime = System.nanoTime() - start;

        // Quick Sort
        start = System.nanoTime();
        quickSort(arr3);
        long quickTime = System.nanoTime() - start;

        // Results
        System.out.printf("Dataset Size: %,d\n", size);
        System.out.printf("Bubble Sort Time: %.3f ms\n", bubbleTime / 1e6);
        System.out.printf("Merge Sort Time: %.3f ms\n", mergeTime / 1e6);
        System.out.printf("Quick Sort Time: %.3f ms\n", quickTime / 1e6);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Sorting Algorithm Performance Comparison\n");

        compareSorts(1_000);
        compareSorts(10_000);
        compareSorts(1_000_000);
    }
}
