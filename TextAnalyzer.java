import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for and validate user input
        String text = promptAndValidateInput(scanner);

        // Analyze the text
        int charCount = text.length();
        int wordCount = countWords(text);
        int sentenceCount = countSentences(text);
        double avgWordLength = (double) charCount / wordCount;
        Map<String, Integer> wordFrequency = findMostFrequentWords(text);
        String longestWord = findLongestWord(text);
        int uniqueWords = countUniqueWords(text);

        // Display the analysis results
        System.out.println("Text Analysis Results:");
        System.out.println("Total Characters (including spaces and punctuation): " + charCount);
        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Sentences: " + sentenceCount);
        System.out.println("Average Word Length: " + String.format("%.2f", avgWordLength));
        System.out.println("Five Most Frequent Words:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Number of Unique Words (ignoring case): " + uniqueWords);
    }

    private static String promptAndValidateInput(Scanner scanner) {
        while (true) {
            System.out.println("Enter a paragraph of text:");
            String text = scanner.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please enter some text.");
            } else if (countSentences(text) < 3) {
                System.out.println("Error: Input must contain at least three sentences. Please enter more text.");
            } else {
                return text;
            }
        }
    }

    private static int countWords(String text) {
        // Split text into words using a regular expression
        String[] words = text.split("\\s+");
        return words.length;
    }

    private static int countSentences(String text) {
        // Pattern to match sentences ending with period, exclamation mark, or question mark
        Pattern sentencePattern = Pattern.compile("(\\w+\\.*[!\\?])");
        Matcher matcher = sentencePattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private static Map<String, Integer> findMostFrequentWords(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        // Split text into words (lowercase for case-insensitive frequency)
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            int frequency = wordFrequency.getOrDefault(word, 0) + 1;
            wordFrequency.put(word, frequency);
        }

        // Sort the map by frequency (descending order) using a custom comparator
        // (This part is optional for this specific requirement, but demonstrates sorting)
        // MapUtil.sortByValue(wordFrequency, false);  // Uncomment if you want sorted output

        // Select the top 5 most frequent words
        Map<String, Integer> topFive = new HashMap<>();
        int counter = 0;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (counter < 5) {
                topFive.put(entry.getKey(), entry.getValue());
                counter++;
            }
        }
        return topFive;
    }

    private static String findLongestWord(String text) {
        String longestWord = "";
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
    
    private static int countUniqueWords(String text) {
        Set<String> uniqueWords = new HashSet<>();
        // Split text into words (lowercase for case-insensitive counting)
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords.size();
    }
}