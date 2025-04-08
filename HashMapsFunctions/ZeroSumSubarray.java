import java.util.*;

public class ZeroSumSubarray {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Add sum = 0 at index -1 to handle subarrays starting at index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i}); // Subarray from (start+1) to i
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    // Utility to print subarrays
    public static void printSubarrays(int[] arr, List<int[]> subarrays) {
        for (int[] sub : subarrays) {
            System.out.print("Subarray: ");
            for (int i = sub[0]; i <= sub[1]; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);
        System.out.println("Zero-sum subarrays:");
        printSubarrays(arr, subarrays);
    }
}
