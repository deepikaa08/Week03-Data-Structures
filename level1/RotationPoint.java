public class RotationPoint {
    public static void main(String[] args) {
        int[] rotatedArray = {15, 18, 2, 3, 6, 12}; // Example rotated sorted array

        int index = findRotationPoint(rotatedArray);

        System.out.println("Index of the smallest element (rotation point): " + index);
        System.out.println("Smallest element: " + rotatedArray[index]);
    }

    // Method to find the rotation point (index of the smallest element)
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                // Smallest is in the right half
                left = mid + 1;
            } else {
                // Smallest is in the left half including mid
                right = mid;
            }
        }

        // At the end of loop, left == right
        return left;
    }
}
