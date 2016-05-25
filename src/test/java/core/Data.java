package core;

import java.io.File;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class Data {

    public static final String stopWordsFilePath = new File("src/test/resources/stop_words.txt").getAbsolutePath();
    public static final String textFilePath = new File("src/test/resources/text.txt").getAbsolutePath();
    public static final String warAndPeaceFilePath = new File("src/test/resources/war_and_peace.txt").getAbsolutePath();
    public static final String testResultsFilePath = new File("src/test/resources/test_results.txt").getAbsolutePath();
    public static final String wordnetDatabaseDir = new File("C:/jaws/wn3.1.dict/dict").getAbsolutePath();
}