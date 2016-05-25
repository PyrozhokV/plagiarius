import core.Analyzer;
import core.Data;
import core.Normalizer;
import core.Word;
import org.testng.reporters.Files;
import utils.FileMan;
import utils.Logger;
import utils.StringMan;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class Test {

    @org.testng.annotations.Test
    public void test() throws IOException {
        String text = FileMan.readTextFromFile(Data.warAndPeaceFilePath);
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


        int max = 0;
        int ind = 0;
        String[] result = new String[terms.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = terms[i].getActual();
            if (max < terms[i].getOriginalTermFrequency()) {
                max = terms[i].getOriginalTermFrequency();
                ind = i;
            }
            System.out.println(terms[i].getOriginal() + ":" + terms[i].getActual() + ":" + terms[i].getOriginalTermFrequency());
        }
        Logger.error(terms[ind].getOriginal() + ":" + terms[ind].getActual() + ":" + terms[ind].getOriginalTermFrequency());



        FileMan.writeToFile(Data.testResultsFilePath, result);
    }

    @org.testng.annotations.Test
    public void hashTest() {
        Set<String> set = new HashSet<String>();
        set.add("sss");
        set.add("sds");
        set.add("sds");
        set.add("sss");
        for (String s : set) {
            System.out.println(s);
        }
    }

    @org.testng.annotations.Test
    public void synTest() {
        Analyzer analyzer = new Analyzer();
        String[] synonyms = analyzer.getSynonyms("insure");
        StringMan.printWords(synonyms);
    }
}
