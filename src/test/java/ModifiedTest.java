import core.*;
import org.testng.annotations.Test;
import utils.FileMan;
import utils.Logger;
import utils.StringMan;

import java.io.IOException;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class ModifiedTest {

    private int shingleLength = 2;
    private int commonWords = 1;

    @Test
    public void modifiedTest() throws IOException {
        Shingle[] original = getShingles(Data.originalTextFilePath);
        Shingle[] plagiarism = getShingles(Data.plagiarismTextFilePath);
//        Shingle[] original = getShingles(Data.originalTextFilePath);
//        Shingle[] plagiarism = getShingles(Data.plagiarismTextFilePath);

        Algorithmizer algorithmizer = new Algorithmizer();
        Logger.error("===============================================\nPlagiarism Ratio = " + algorithmizer.getShinglesRatio(original, plagiarism));


//        String[] shinglesValues = new String[original.length];
//        String[] shinglesHash = new String[original.length];
//        for (int i = 0; i < original.length; i++) {
//            shinglesValues[i] = original[i].toString();
//            shinglesHash[i] = original[i].getHash();
//        }
//        FileMan.writeToFile(Data.testResultsFilePath, shinglesValues);
//
//        String[] shinglesValues2 = new String[plagiarism.length];
//        String[] shinglesHash2 = new String[plagiarism.length];
//        for (int i = 0; i < plagiarism.length; i++) {
//            shinglesValues2[i] = plagiarism[i].toString();
//            shinglesHash2[i] = plagiarism[i].getHash();
//        }
//        FileMan.writeToFile(Data.testResultsFilePath2, shinglesValues2);

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
            terms[i].setSynonyms(analyzer.getSynonyms(words[i]));
            terms[i].setActual(StringMan.alphabeticalSort(terms[i].getSynonyms())[0]);
//            terms[i].setOriginalTF(analyzer.getWordFrequency(terms[i].getOriginal(), words));

//            terms[i].setActual(terms[i].getOriginal());
        }
        Algorithmizer algorithmizer = new Algorithmizer();
        return algorithmizer.shinglesAlgorithm(shingleLength, terms, commonWords);
    }
}
