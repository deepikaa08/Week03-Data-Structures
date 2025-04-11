import java.io.*;
import java.util.Arrays;

public class PerformanceAndWordCount {
    public static void main(String[] args) {
        // ==== PART 1: Compare StringBuilder and StringBuffer ====
        String[] words = {"hello", "world", "java", "performance"};

        // StringBuilder test
        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            for (String word : words) {
                stringBuilder.append(word);
            }
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // StringBuffer test
        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            for (String word : words) {
                stringBuffer.append(word);
            }
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        System.out.println("StringBuilder time: " + builderTime / 1_000_000 + " ms");
        System.out.println("StringBuffer  time: " + bufferTime / 1_000_000 + " ms");

        // ==== PART 2: Read large file and count words ====
        String filePath = "largefile.txt"; // update with your 100MB file path
        long wordCount = 0;
        long startRead = System.nanoTime();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Split line into words using whitespace
                String[] splitWords = line.trim().split("\\s+");
                wordCount += Arrays.stream(splitWords)
                                   .filter(word -> !word.isEmpty())
                                   .count();
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        long endRead = System.nanoTime();
        long readTime = endRead - startRead;

        System.out.println("Total words in file: " + wordCount);
        System.out.println("File read and word count time: " + readTime / 1_000_000 + " ms");
    }
}
