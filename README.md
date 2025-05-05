# Text Analyzer

This Java program, `TextAnalyzer.java`, analyzes a given paragraph of text and provides several statistics.

## Features

The program calculates and displays the following:

* Total number of characters (including spaces and punctuation)
* Total number of words
* Total number of sentences
* Average word length
* The five most frequent words
* The longest word
* The number of unique words (case-insensitive)

## How to Use

1.  Compile the Java code using a Java compiler (like javac):

    ```bash
    javac TextAnalyzer.java
    ```

2.  Run the compiled code:

    ```bash
    java TextAnalyzer
    ```

3.  The program will prompt you to enter a paragraph of text.  The input must:
    * Not be empty.
    * Contain at least three sentences.

4.  The program will then display the analysis results.

## Code Explanation

The `TextAnalyzer.java` file contains the following methods:

* `main(String[] args)`: The entry point of the program.  It gets user input, calls the analysis methods, and displays the results.
* `promptAndValidateInput(Scanner scanner)`: Prompts the user to enter text and validates that the input is not empty and contains at least three sentences.
* `countWords(String text)`: Counts the number of words in the text using a regular expression to split the text by spaces.
* `countSentences(String text)`: Counts the number of sentences using a regular expression to match sentence-ending punctuation (., !, ?).
* `findMostFrequentWords(String text)`: Finds the five most frequent words (case-insensitive).  It uses a `HashMap` to store word frequencies.
* `findLongestWord(String text)`: Finds the longest word in the text.
* `countUniqueWords(String text)`: Counts the number of unique words (case-insensitive) using a `HashSet`.
