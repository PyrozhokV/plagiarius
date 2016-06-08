package core;

import java.io.File;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class Data {

    public static final String stopWordsFilePath = new File("src/test/resources/stop_words.txt").getAbsolutePath();

    public static final String originalTextFilePath =
            new File("C:\\Users\\Pyrozhok\\IdeaProjects\\plagiarius\\plagiarius\\src\\test\\resources\\test\\syn50000x75\\Fahrenheit_451_1443713678.txt").getAbsolutePath();
    public static final String plagiarismTextFilePath =
            new File("C:\\Users\\Pyrozhok\\IdeaProjects\\plagiarius\\plagiarius\\src\\test\\resources\\test\\syn50000x75\\2.txt").getAbsolutePath();





    public static final String warAndPeaceFilePath = new File("src/test/resources/war_and_peace.txt").getAbsolutePath();
    public static final String testResultsFilePath2 = new File("src/test/resources/test_results.txt").getAbsolutePath();
    public static final String testResultsFilePath = new File("src/test/resources/test_results2.txt").getAbsolutePath();
    public static final String wordnetDatabaseDir = new File("C:/jaws/wn3.1.dict/dict").getAbsolutePath();
}
