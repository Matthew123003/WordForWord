package src.main.java;

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


    public static void main(String[] args) {

        WordForWord wfw = new WordForWord();

        wfw.loadFile("testdata1.txt");

        wfw.processAll();

        System.out.println(wfw.toString());
    }

    public String toString() {
       return ""; // create a brief report on what you found out about the file contents.
    }

    private void processAll() {
    }

    private void loadFile(String file) {
    }

}
