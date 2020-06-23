package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Classname: Main
 *
 * @version 23.06.2020
 * @author Kopach Daria
 *
 * 1. GLOSSARY - 10 points
 *
 * 1.1. Download a text about Harry Potter.
 * 1.2. For each distinct word in the text calculate the number of occurrence.
 * 1.3. Use RegEx..
 * 1.4. Sort in the DESC mode by the number of occurrence..
 * 1.5. Find  the first 20 pairs.
 * 1.6  Find all the proper names
 * 1.7.  Count them and arrange in alphabetic order.
 * 1.8.   First 20 pairs and names write into to a file test.txt
 * 1.9.  Create a fine header for the file
 * 1.10  Use Java  Collections to demonstrate your experience (Map, List )
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
            String text = new String(Files.readAllBytes(Paths.get
                    ("C:\\Users\\Nastya\\Desktop\\Harry.txt")));

        String word = "";
        int index = 1;
        String[] words = text.toLowerCase().replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll("\"", "")
                .replaceAll("", "")
                .replaceAll("/", "")
                .replaceAll("!", "")
                .replaceAll(";", "")
                .replaceAll(":", "")
                .replaceAll("\\?", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\"", "")
                .replaceAll("\n", "")
                .replaceAll("0'", "")
                .replaceAll("--", "")
                .replaceAll(" -", "")
                .replaceAll(" - ", "")
                .replaceAll("- ", "")
                .replaceAll("' ", "")
                .replaceAll(" '", "")
                .replaceAll(" ' ", "")
                .replaceAll("'", "")
                .replaceAll("1", "")
                .replaceAll("2", "")
                .replaceAll("3", "")
                .replaceAll("4", "")
                .replaceAll("5", "")
                .replaceAll("6", "")
                .replaceAll("7", "")
                .replaceAll("8", "")
                .replaceAll("9", "")
                .replaceAll("", "")
                .replaceAll("0", "")
                .toLowerCase().split("\\s");
        Arrays.sort(words);
        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(words[i - 1])) {
                index++;
            } else if (!words[i].equals(words[i - 1])) {
                word = words[i - 1];
                System.out.println("Слово '" + word + "' встречается в тексте: " + index + " раз.");
                index = 1;
            }
            word=words[i-1];
        }

    }
}
