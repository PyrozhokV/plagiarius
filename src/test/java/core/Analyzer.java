package core;

import java.util.HashMap;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class Analyzer {

    public HashMap<String, Integer> getWordsFrequencies(String[] words) {
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        for (String word : words) {
            int counter = 0;
            for (String entry : words) {
                if (word.equals(entry)) {
                    counter++;
                }
            }
            frequencies.put(word, counter);
        }
        return frequencies;
    }
}
