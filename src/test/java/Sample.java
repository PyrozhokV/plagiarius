import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import org.apache.lucene.analysis.*;
import org.apache.lucene.util.Version;
import org.apache.lucene.wordnet.SynonymMap;
import org.apache.lucene.wordnet.SynonymTokenFilter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Pyrozhok on 10.05.2016.
 */
public class Sample {

    final String testFile = "C:\\Users\\Pyrozhok\\IdeaProjects\\pdffiller-tests_v2\\plagiarius\\src\\test\\resources\\synonyms.txt";

    String[] words = new String[] { "hard", "woods", "forest", "wolfish", "xxxx"};

    @Test
    public void test() throws IOException {
        SynonymMap map = new SynonymMap(new FileInputStream("samples/fulltext/wn_s.pl"));
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = map.getSynonyms(words[i]);
            System.out.println(words[i] + ":" + java.util.Arrays.asList(synonyms).toString());
        }
    }

    @Test
    public void test2() {
        NounSynset nounSynset;
        NounSynset[] hyponyms;
        System.setProperty("wordnet.database.dir", "C:/jaws/wn3.1.dict/dict");

        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset[] synsets = database.getSynsets("pressure", SynsetType.NOUN);
        for (int i = 0; i < synsets.length; i++) {
            nounSynset = (NounSynset) (synsets[i]);
            hyponyms = nounSynset.getHyponyms();
            System.out.println(nounSynset.getWordForms()[0] +
                    ": " + nounSynset.getDefinition() + "; has " + hyponyms.length + " hyponyms");
        }
    }
}
