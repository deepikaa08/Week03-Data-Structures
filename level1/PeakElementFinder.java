public class PeakElementFinder {
    public static void main(String[] args) {
        int[] nums = {1, 3, 20, 4, 1, 0}; // Example array

        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element found at index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftIsSmaller = (mid == 0 || nums[mid] > nums[mid - 1]);
            boolean rightIsSmaller = (mid == n - 1 || nums[mid] > nums[mid + 1]);

            if (leftIsSmaller && rightIsSmaller) {
                // nums[mid] is a peak
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                // Peak is on the left
                right = mid - 1;
            } else {
                // Peak is on the right
                left = mid + 1;
            }
        }

        // Should never be reached if input is valid
        return -1;
    }
}
