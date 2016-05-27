package trash;

import core.Analyzer;
import core.Lemmatizer;
import jdk.internal.org.objectweb.asm.commons.AnalyzerAdapter;
import org.testng.annotations.Test;
import utils.StringMan;

/**
 * Created by Pyrozhok on 28.05.2016.
 */
public class LemmaSample {

    @Test
    public void test() {
        Lemmatizer lemmatizer = new Lemmatizer();
        System.out.println(lemmatizer.lemmatize("esop"));

        Analyzer analyzer = new Analyzer();
        StringMan.printWords(analyzer.getSynonyms("esop"));
    }
}
