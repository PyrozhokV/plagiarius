package core;

import utils.FileMan;
import utils.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class Normalizer {

    private String[] stopWords = FileMan.readTextFromFile(Data.stopWordsFilePath).split("\\s");;

    public String[] getStopWords() {
        return stopWords;
    }

    public String[] normalize(String originalText) {
        Logger.error("Original text words count: " + originalText.split("\\s").length);
        List<String> words = Arrays.asList(originalText.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"));
        List<String> stopWordsList = Arrays.asList(stopWords);
        List<String> wordsAfterCleaning = new ArrayList<String>();
        for (String word : words) {
            boolean isAllowed = !((word.length() == 1) || (stopWordsList.contains(word)));
            if (isAllowed) {
                wordsAfterCleaning.add(word);
            }
        }
        String[] result = new String[wordsAfterCleaning.size()];
        for (int i = 0; i < wordsAfterCleaning.size(); i++) {
            result[i] = wordsAfterCleaning.get(i);
        }
        return result;
    }
}
