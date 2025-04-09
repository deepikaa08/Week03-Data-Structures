import java.util.Scanner;

public class SelectionSort {

    // Method to perform Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] examScores = new int[n];

        // Input exam scores
        System.out.println("Enter the exam scores of " + n + " students:");
        for (int i = 0; i < n; i++) {
            examScores[i] = scanner.nextInt();
        }

        // Sort using Selection Sort
        selectionSort(examScores);

        // Output sorted scores
        System.out.println("Sorted exam scores in ascending order:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }

        scanner.close();
    }
}
