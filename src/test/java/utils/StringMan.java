package utils;

import core.Word;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.CRC32;

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

    public static String[] alphabeticalSort(String[] words) {
        Collections.sort(Arrays.asList(words));
        return words;
    }

    public static Word[] alphabeticalSort(Word[] words) {
        Collections.sort(Arrays.asList(words));
        return words;
    }

    public static String getHashCRC32(String input) {
        CRC32 crc = new CRC32();
        crc.update(input.getBytes());
        return Long.toHexString(crc.getValue());
    }

    public static String getHashSHA256(String input) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(input.getBytes());
        StringBuffer result = new StringBuffer();
        for (byte byt : md.digest()) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }
}
