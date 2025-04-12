import java.util.*;

public class ComparingDataStructures {

    // Linear search for Array (O(N))
    public static boolean searchInArray(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    // Search in HashSet (O(1) on average)
    public static boolean searchInHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Search in TreeSet (O(log N))
    public static boolean searchInTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Measure the performance of Array, HashSet, and TreeSet for searching
    public static void compareSearchPerformance(int n) {
        // Generate a sample dataset for comparison
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
            treeSet.add(i);
        }

        System.out.printf("Search Performance for N = %,d:\n", n);

        // Search in Array (O(N))
        long start = System.nanoTime();
        searchInArray(array, n - 1);  // Searching for the last element
        long arrayTime = System.nanoTime() - start;

        // Search in HashSet (O(1))
        start = System.nanoTime();
        searchInHashSet(hashSet, n - 1);  // Searching for the last element
        long hashSetTime = System.nanoTime() - start;

        // Search in TreeSet (O(log N))
        start = System.nanoTime();
        searchInTreeSet(treeSet, n - 1);  // Searching for the last element
        long treeSetTime = System.nanoTime() - start;

        // Results
        System.out.printf("Array Search Time: %.3f ms\n", arrayTime / 1e6);
        System.out.printf("HashSet Search Time: %.3f ms\n", hashSetTime / 1e6);
        System.out.printf("TreeSet Search Time: %.3f ms\n", treeSetTime / 1e6);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Search Performance Comparison\n");

        // Comparing search performance for different dataset sizes
        compareSearchPerformance(1_000);      // N = 1,000
        compareSearchPerformance(100_000);    // N = 100,000
        compareSearchPerformance(1_000_000); // N = 1,000,000
    }
}
