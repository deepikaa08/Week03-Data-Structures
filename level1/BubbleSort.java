import java.util.Scanner;

public class BubbleSort{

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap if the current element is greater than the next
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, break
            if (!swapped) break;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];

        // Input student marks
        System.out.println("Enter the marks of " + n + " students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        // Sort marks using Bubble Sort
        bubbleSort(marks);

        // Output sorted marks
        System.out.println("Sorted student marks in ascending order:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        scanner.close();
    }
}
