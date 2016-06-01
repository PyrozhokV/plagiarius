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

    private int shingleLength = 2;
    private int commonWords = 1;

    @Test
    public void test() throws IOException {
        Shingle[] original = getShingles(Data.originalTextFilePath);
        Shingle[] plagiarism = getShingles(Data.plagiarismTextFilePath);

        Algorithmizer algorithmizer = new Algorithmizer();
        Logger.error("Plagiarism Ratio = " + algorithmizer.getShinglesRatio(original, plagiarism));





//        String[] shinglesValues = new String[shingles.length];
//        String[] shinglesHash = new String[shingles.length];
//        for (int i = 0; i < shingles.length; i++) {
//            shinglesValues[i] = shingles[i].toString();
//            shinglesHash[i] = shingles[i].getHash();
//        }
//        FileMan.writeToFile(Data.testResultsFilePath, shinglesValues);

    }

    private Shingle[] getShingles(String filePath) {
        String text = FileMan.readTextFromFile(filePath);
        Analyzer analyzer = new Analyzer();
        Normalizer normalizer = new Normalizer();
        String[] words = normalizer.normalize(text);
        Logger.error("Words count = [" + words.length + "]");
        Word[] terms = new Word[words.length];
        for (int i = 0; i < terms.length; i++) {
//            System.out.println(i + ". Word [" + words[i] + "]");
            terms[i] = new Word(words[i]);
            terms[i].setSynonyms(analyzer.getSynonyms(words[i]));
            terms[i].setActual(StringMan.alphabeticalSort(terms[i].getSynonyms())[0]);
            terms[i].setOriginalTF(analyzer.getWordFrequency(terms[i].getOriginal(), words));
        }
        Algorithmizer algorithmizer = new Algorithmizer();
        return algorithmizer.shinglesAlgorithm(shingleLength, terms, commonWords);
    }
}
