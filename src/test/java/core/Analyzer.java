package core;

import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.WordNetDatabase;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import utils.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class Analyzer {

    private Normalizer normalizer;

    public Analyzer() {
        System.setProperty("wordnet.database.dir", Data.wordnetDatabaseDir);
        normalizer = new Normalizer();
    }

    public int getWordFrequency(String word, String[] words) {
        int counter = 0;
        for (String entry : words) {
            if (word.equals(entry)) {
                counter++;
            }
        }
        return counter;
    }

    public String[] getSynonyms(String word) {
        String[] allWordForms = {};
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset[] synsets = database.getSynsets(word);
        for (Synset synset : synsets) {
            allWordForms = ArrayUtils.addAll(allWordForms, synset.getWordForms());
        }
        Set<String> synonymsSet = new HashSet<String>();
        Lemmatizer lemmatizer = new Lemmatizer();
        synonymsSet.add(lemmatizer.lemmatize(word));
        for (int i = 0; i < allWordForms.length; i++) {
            String[] wordForm = allWordForms[i].split("\\s");
            boolean isWordFormAllowed = (wordForm.length == 1)
                                        && (!Arrays.asList(normalizer.getStopWords()).contains(wordForm[0])
                                        && StringUtils.isAlpha(wordForm[0]));
            if (isWordFormAllowed) {
                synonymsSet.add(allWordForms[i]);
            }
        }
        String[] synonyms = {};
        return synonymsSet.toArray(synonyms);
    }
}
