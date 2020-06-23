package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Classname: Main
 *
 * @author Kopach Daria
 * <p>
 * 1. GLOSSARY - 10 points
 * <p>
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
 * @version 23.06.2020
 */


public class Main {

    final static String outputFilePath = "C:\\Users\\Nastya\\Desktop\\text.txt";

    /**
     * Main method to execute
     *
     * @param args String params.
     * @throws IOException throws error if there is no file exists.
     */

    public static void main(String[] args) throws IOException {

        //1.1. Download a text about Harry Potter.

        String text = new String(Files.readAllBytes(Paths.get
                ("C:\\Users\\Nastya\\Desktop\\Harry.txt")));

        String[] allWords = text
                .replaceAll("[\\s\\.\\?\\!,\\-\":;]+", " ")
                .split("\\s+");

        // String with distinct words
        String dictinctWords = "";

        for (String word : allWords) {
            if (!dictinctWords.contains(word)) {
                dictinctWords += word + " ";
            }
        }

        // Convert string to array splitting it by spaces
        String[] dictinctWordsArray = dictinctWords.split(" ");

        // 1.2. For each distinct word in the text calculate
        // the number of occurrence.

        Map<String, Integer> occurrenceNumber = new HashMap<>();
        for (String word : allWords) {
            if (occurrenceNumber.containsKey(word)) {
                occurrenceNumber.put(word, occurrenceNumber.get(word) + 1);
            } else {

                occurrenceNumber.put(word, 1);
            }
        }

        for (Entry<String, Integer> entry : occurrenceNumber.entrySet()) {
        }

        // 1.4. Sort in the DESC mode by the number of occurrence.

        Map<String , Integer> sortedList = occurrenceNumber.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        //print sorted list of all words

        sortedList.forEach((key,value)->{
            System.out.println(key + " - " + value);
        });

        //get the first 20 pairs

        List<String> keys = new ArrayList<>();
        Map<String, Integer> first20Pairs = new LinkedHashMap<>();
        sortedList.keySet().stream().forEach(key-> keys.add(key));
        for (int i = 0; i < 20; i++) {
            first20Pairs.put(keys.get(i), sortedList.get(keys.get(i)));
        }

        //print sorted list of the first 20 words
        first20Pairs.forEach((key,value)->{
            System.out.println(key + " - " + value);
        });

        System.out.println("First 20 pairs:");
        // create Iterator 'items' to be able to switch to next DescendingSortedMap elements from beginning
        Iterator<Map.Entry<String, Integer>> items = first20Pairs.entrySet().iterator();

        Path path = Paths.get("C:\\Users\\Nastya\\Desktop\\text.txt");

        for (int i = 0; i < 20; i++) {
            Map.Entry<String, Integer> pairs = items.next(); // get next item
            System.out.format("Word: ", pairs.getKey(), pairs.getValue());
            // write occurrence pair to the file
            Files.write(path, (pairs.getKey() + "\n").getBytes());
        }

                // 1.6  Find all the proper names.

        List<String> properNames = new ArrayList<>();

        for (String value : occurrenceNumber.keySet()) {
            if (value.length() > 2
                    && Character.isUpperCase(value.charAt(0))
                    && Character.isLowerCase(value.charAt(1))) {

                properNames.add(value);
            }
        }

        // 1.7. Count them and arrange in alphabetic order.

        Collections.sort(properNames);
        int properNamesCount = properNames.size();
        System.out.println("In text are " + properNamesCount + " proper names. ");

        // 1.8. First 20 pairs and names write into to a file test.txt

        System.out.println("The first 20 names in alphabet order are: ");
        for (int i = 0; i < 20; i++) {

            System.out.println(properNames.get(i));

            Path path1 = Paths.get("C:\\Users\\Nastya\\Desktop\\text.txt");
            Files.write(path, properNames.get(i).getBytes());


        }
    }
}