package utils;

import java.util.Arrays;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class StringMan {

    public static void printWords(String[] words) {
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void printWords(String words) {
        String[] wordsList = words.replaceAll("\r", "").split("\\s");
        for (String word : wordsList) {
            System.out.println(word);
        }
    }

    public static boolean arrayContains(String[] words, String word) {
        return Arrays.asList(words).contains(word);
    }

    public static boolean textContains(String text, String word) {
        return Arrays.asList(text.replaceAll("\r", "").split("\\s")).contains(word);
    }
}
