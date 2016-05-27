import core.*;
import org.testng.annotations.Test;
import utils.FileMan;
import utils.Logger;
import utils.StringMan;

import java.io.IOException;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class MainTest {

    @Test
    public void test() throws IOException {
        String text = FileMan.readTextFromFile(Data.textFilePath);
        Analyzer analyzer = new Analyzer();
        Normalizer normalizer = new Normalizer();
        String[] words = normalizer.normalize(text);
        Logger.error("Words count = [" + words.length + "]");
        Word[] terms = new Word[words.length];
        for (int i = 0; i < terms.length; i++) {
            System.out.println(i + ". Word [" + words[i] + "]");
            terms[i] = new Word(words[i]);
            terms[i].setSynonyms(analyzer.getSynonyms(words[i]));
            terms[i].setActual(StringMan.getFirstFromAlphabeticalSorted(terms[i].getSynonyms()));
            terms[i].setOriginalTermFrequency(analyzer.getWordFrequency(terms[i].getOriginal(), words));
        }

        Algorithmizer algorithmizer = new Algorithmizer();
        Shingle[] shingles = algorithmizer.shinglesAlgorithm(9, terms);
//        int max = 0;
//        int ind = 0;
        String[] result = new String[shingles.length];
        for (int i = 0; i < shingles.length; i++) {
            result[i] = shingles[i].toString();
        }
//        for (int i = 0; i < result.length; i++) {
//            result[i] = terms[i].getActual();
//            if (max < terms[i].getOriginalTermFrequency()) {
//                max = terms[i].getOriginalTermFrequency();
//                ind = i;
//            }
//            System.out.println(terms[i].getOriginal() + ":" + terms[i].getActual() + ":" + terms[i].getOriginalTermFrequency());
//        }
//        Logger.error(terms[ind].getOriginal() + ":" + terms[ind].getActual() + ":" + terms[ind].getOriginalTermFrequency());
        FileMan.writeToFile(Data.testResultsFilePath, result);







    }
}
