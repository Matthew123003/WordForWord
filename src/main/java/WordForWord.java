package src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Four phases of text processing to do. Write a method for each one.
 *
 * public void print()  - write a method that reads the contents of a file, line by line, and creates a String object,
 * making sure all the newlines are preserved. use BufferedReader to do the reading.
 *
 * For the sake of this lab, words are not and do not have punctuation.
 *
 * public WCResult wc(String input)
 * commonly called "wc"; count the number of characters in a file, number of words, number of lines.
 * Returns an object of class WCResult (a POJO) which consists of the three longs you counted.
 *
 * public FrequencyMap wordFrequency(String input)
 * word count. words in a file, produce a map with (String word, Long numOfTimes). FrequencyMap returning a HashMap might be what you're
 * looking for here, or maybe something else.
 *
 * public FrequencyMap letterFrequency(String input)
 * letter frequency, write a program that collects the frequency of each letter within the input.
*/

public class WordForWord {

    // You'll need to setup some instance variables for the phases of processing
    // you need to do on the text in the file(s).
    // And where SHOULD those POJO classes go? Inner classes? Separate public classes?
    // The decision depends on how you envision using the methods in this class.
    private String fileContent;
    private WCResult wcResult;
    private FrequencyMap wordFrequencyMap;
    private FrequencyMap letterFrequencyMap;



    public static void main(String[] args) {

        WordForWord wfw = new WordForWord();

        wfw.loadFile("/Users/matthew123003/IdeaProjects/WordForWord/testdata/testdata7.txt");

        wfw.processAll();

        System.out.println(wfw.toString());
    }

    public void loadFile(String file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileContent = content.toString();
    }

    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append("File Statistics:\n");
        report.append("Characters: ").append(wcResult.getCharCount()).append("\n");
        report.append("Words: ").append(wcResult.getWordCount()).append("\n");
        report.append("Lines: ").append(wcResult.getLineCount()).append("\n\n");
        report.append("Word Frequency:\n");
        wordFrequencyMap.forEach((word, count) -> report.append(word).append(": ").append(count).append("\n"));
        report.append("\nLetter Frequency:\n");
        letterFrequencyMap.forEach((letter, count) -> report.append(letter).append(": ").append(count).append("\n"));
        return report.toString();
    }

    private void processAll() {
        wcResult = wc(fileContent);
        wordFrequencyMap = wordFrequency(fileContent);
        letterFrequencyMap = letterFrequency(fileContent);
    }

    public WCResult wc(String input) {
        long charCount = input.length();
        long wordCount = input.split("\\s+").length;
        long lineCount = input.lines().count();
        return new WCResult(charCount, wordCount, lineCount);
    }

    public FrequencyMap wordFrequency(String input) {
        String[] words = input.split("\\s+");
        FrequencyMap frequencyMap = new FrequencyMap();
        for (String word : words) {
            frequencyMap.increment(word);
        }
        return frequencyMap;
    }

    public FrequencyMap letterFrequency(String input) {
        char[] letters = input.replaceAll("\\s+", "").toCharArray();
        FrequencyMap frequencyMap = new FrequencyMap();
        for (char letter : letters) {
            frequencyMap.increment(String.valueOf(letter));
        }
        return frequencyMap;
    }
}

class WCResult {
    private final long charCount;
    private final long wordCount;
    private final long lineCount;

    public WCResult(long charCount, long wordCount, long lineCount) {
        this.charCount = charCount;
        this.wordCount = wordCount;
        this.lineCount = lineCount;
    }

    public long getCharCount() {
        return charCount;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getLineCount() {
        return lineCount;
    }
}

class FrequencyMap extends HashMap<String, Long> {
    public void increment(String key) {
        this.put(key, this.getOrDefault(key, 0L) + 1);
    }
}




