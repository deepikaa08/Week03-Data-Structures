import java.util.Arrays;

public class SearchOperations {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 4;

        int missing = findFirstMissingPositive(nums.clone()); // Use clone to avoid sorting affecting original
        System.out.println("First missing positive integer: " + missing);

        Arrays.sort(nums); // Sort for binary search
        int index = binarySearch(nums, target);
        System.out.println("Index of target " + target + ": " + index);
    }

    // Linear Search logic to find first missing positive
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Marking phase
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with its correct position
                int correctIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
            }
        }

        // Finding missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1; // All numbers from 1 to n are present
    }

    // Binary Search logic to find target index
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
}
