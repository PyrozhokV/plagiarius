import core.*;
import org.testng.annotations.Test;
import utils.FileMan;
import utils.Logger;
import utils.StringMan;

import java.io.IOException;

/**
 * Created by Pyrozhok on 08.06.2016.
 */
public class OriginalTest {

    private int shingleLength = 2;
    private int commonWords = 1;


    @Test
    public void originalTest() throws IOException {
        Shingle[] original = getShingles(Data.originalTextFilePath);
        Shingle[] plagiarism = getShingles(Data.plagiarismTextFilePath);
//        Shingle[] original = getShingles(Data.originalTextFilePath);
//        Shingle[] plagiarism = getShingles(Data.plagiarismTextFilePath);

        Algorithmizer algorithmizer = new Algorithmizer();
        Logger.error("===============================================\nPlagiarism Ratio = " + algorithmizer.getShinglesRatio(original, plagiarism));



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
        Logger.info("===============================================");
        Logger.error("Words count = [" + words.length + "]");
        Word[] terms = new Word[words.length];
        for (int i = 0; i < terms.length; i++) {
//            System.out.println(i + ". Word [" + words[i] + "]");
            terms[i] = new Word(words[i]);
//            terms[i].setSynonyms(analyzer.getSynonyms(words[i]));
//            terms[i].setActual(StringMan.alphabeticalSort(terms[i].getSynonyms())[0]);
//            terms[i].setOriginalTF(analyzer.getWordFrequency(terms[i].getOriginal(), words));

            terms[i].setActual(terms[i].getOriginal());
        }
        Algorithmizer algorithmizer = new Algorithmizer();
        return algorithmizer.shinglesAlgorithm(shingleLength, terms, commonWords);
    }
}
