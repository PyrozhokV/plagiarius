package trash;

import org.testng.annotations.Test;
import utils.StringMan;

/**
 * Created by Pyrozhok on 30.05.2016.
 */
public class HashSample {

    @Test
    public void test() {
        System.out.println(StringMan.getHashSHA256("token"));
        System.out.println(StringMan.getHashSHA256("token"));
    }
}
