public class SpecificWord {
    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue.",
            "Java is a powerful programming language.",
            "I love reading books.",
            "Today is a beautiful day."
        };

        String wordToFind = "Java"; // change as needed

        String result = findSentenceContainingWord(sentences, wordToFind);

        System.out.println("Result: " + result);
    }

    // Method to search for the first sentence containing the word
    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
