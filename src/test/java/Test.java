import core.Data;
import core.Normalizer;
import org.testng.reporters.Files;
import utils.FileMan;
import utils.StringMan;

import java.io.File;
import java.io.IOException;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class Test {

    @org.testng.annotations.Test
    public void test() throws IOException {
        String text = FileMan.readTextFromFile(Data.textFilePath);
        Normalizer normalizer = new Normalizer(text);
        String[] words = normalizer.normalize();
        FileMan.writeToFile(Data.testResultsFilePath, words);
    }
}
