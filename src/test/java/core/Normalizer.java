package core;

import utils.FileMan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class Normalizer {

    private String originalText;
    private String[] stopWords;

    public Normalizer(String text) {
        this.originalText = text;
        stopWords = FileMan.readTextFromFile(Data.stopWordsFilePath).split("\\s");
    }

    public String getOriginalText() {
        return this.originalText;
    }

    public String[] normalize() {
        List<String> words = Arrays.asList(this.originalText.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"));
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
