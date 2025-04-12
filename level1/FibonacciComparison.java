public class FibonacciComparison {

    // Recursive Fibonacci (O(2^n))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Method to measure time and compare both approaches
    public static void compareFibonacci(int n) {
        System.out.printf("Fibonacci for N = %,d:\n", n);

        // Measure Recursive Fibonacci Time
        long start = System.nanoTime();
        try {
            fibonacciRecursive(n);  // This may take a long time for larger N
        } catch (StackOverflowError e) {
            System.out.println("Recursive approach failed for large N (stack overflow).");
        }
        long recursiveTime = System.nanoTime() - start;

        // Measure Iterative Fibonacci Time
        start = System.nanoTime();
        fibonacciIterative(n);
        long iterativeTime = System.nanoTime() - start;

        // Results
        System.out.printf("Recursive Fibonacci Time: %.3f ms\n", recursiveTime / 1e6);
        System.out.printf("Iterative Fibonacci Time: %.3f ms\n", iterativeTime / 1e6);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Calculation Performance Comparison\n");

        // Comparing Fibonacci for N = 10, 30, and 50
        compareFibonacci(10);   // N = 10
        compareFibonacci(30);   // N = 30
        compareFibonacci(50);   // N = 50
    }
}
