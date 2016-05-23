import org.apache.tools.ant.util.FileUtils;
import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class Test {

    @org.testng.annotations.Test
    public void test() throws IOException {
        String filepath = "src/test/resources/text.txt";
        String text = Files.readFile(new File(filepath));
        Normalizer normalizer = new Normalizer(text);
        String[] words = normalizer.normalize();
        System.out.println();
    }
}
