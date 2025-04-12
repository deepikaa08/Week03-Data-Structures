public class StringComparison {

    // Concatenating using String (inefficient)
    public static String concatWithString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a";  // Inefficient due to immutability
        }
        return result;
    }

    // Concatenating using StringBuilder (efficient)
    public static String concatWithStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("a");  // Efficient, mutable
        }
        return result.toString();
    }

    // Concatenating using StringBuffer (thread-safe but slower than StringBuilder)
    public static String concatWithStringBuffer(int n) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            result.append("a");  // Thread-safe but slower than StringBuilder
        }
        return result.toString();
    }

    // Measure the performance of each concatenation method
    public static void compareConcatenation(int n) {
        System.out.printf("Concatenating %,d strings:\n", n);

        // String Concatenation (O(N²))
        long start = System.nanoTime();
        concatWithString(n);
        long stringTime = System.nanoTime() - start;

        // StringBuilder Concatenation (O(N))
        start = System.nanoTime();
        concatWithStringBuilder(n);
        long stringBuilderTime = System.nanoTime() - start;

        // StringBuffer Concatenation (O(N))
        start = System.nanoTime();
        concatWithStringBuffer(n);
        long stringBufferTime = System.nanoTime() - start;

        // Results
        System.out.printf("String Concatenation Time: %.3f ms\n", stringTime / 1e6);
        System.out.printf("StringBuilder Concatenation Time: %.3f ms\n", stringBuilderTime / 1e6);
        System.out.printf("StringBuffer Concatenation Time: %.3f ms\n", stringBufferTime / 1e6);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("String Concatenation Performance Comparison\n");

        compareConcatenation(1_000);        // 1,000 strings
        compareConcatenation(10_000);       // 10,000 strings
        compareConcatenation(1_000_000);   // 1,000,000 strings
    }
}
