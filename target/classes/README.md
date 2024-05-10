# WordForWord

a series of text processing methods

For the sake of this lab, words are not and do not have punctuation.

Four phases of text processing to do. Write a method for each one.

`public void print()`
Write a method that reads the contents of a file, line by line, and creates a String object,
making sure all the newlines are preserved. use BufferedReader to do the reading.

`public WCResult wc(String input)`
commonly called "wc"; count the number of characters in a file, number of words, number of lines.
Returns an object of class WCResult (a POJO) which consists of the three longs you counted.

`public FrequencyMap wordFrequency(String input)`
word count. words in a file, produce a map with (String word, Long numOfTimes). FrequencyMap returning a HashMap might be what you're
looking for here, or maybe something else.

`public FrequencyMap letterFrequency(String input)`
letter frequency, write a program that collects the frequency of each letter within the input.

A `WCResult` is a class which contains the three Long number created when a text file is `wc`'d.

A `FrequencyMap` is a class which is a POJO that contains a map of the things tracked as a key (a String in this case),
and the number of times it appears in the input.

Input like `The Blue Fox is blue.` would produce a map like

| Word | Count |
|------|-------|
| the  | 1     |
| blue | 2     |
| fox  | 1     |
| is   | 1     |

The class would also have a method `public double frequency(String word)` which returns the relative frequency of the 
word in the input text.
So `frequency("blue")` would return 0.4 as a result.
This means you need to track the total number of words in the input, 
as frequency is `numberOfOccurences / totalNumberOfWords`

