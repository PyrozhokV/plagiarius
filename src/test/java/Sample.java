import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.stanford.nlp.ling.Word;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;
import org.apache.lucene.wordnet.SynonymMap;
import org.apache.lucene.wordnet.SynonymTokenFilter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pyrozhok on 10.05.2016.
 */
public class Sample {

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

    @Test
    public void test1() {
        System.setProperty("wordnet.database.dir", "C:/jaws/wn3.1.dict/dict");
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        List<Synset[]> synsets = new ArrayList<Synset[]>();
        synsets.add(database.getSynsets("man"));
        synsets.add(database.getSynsets("has"));
        synsets.add(database.getSynsets("bought"));
        synsets.add(database.getSynsets("new"));
        synsets.add(database.getSynsets("red"));
        synsets.add(database.getSynsets("car"));

        System.out.println("ADJ = " + SynsetType.ADJECTIVE);
        System.out.println("ADJ_SAT = " + SynsetType.ADJECTIVE_SATELLITE);
        System.out.println("ADVERB = " + SynsetType.ADVERB);
        System.out.println("NOUN = " + SynsetType.NOUN);
        System.out.println("VERB = " + SynsetType.VERB);


//        for (int i = 0; i < synsets.get(0)[0].getUsageExamples().length; i++) {
//            System.out.println(synsets.get(0)[0].getUsageExamples()[i]);
//        }
        for (int i = 0; i < synsets.size(); i++) {
            Synset[] current = synsets.get(i);
            System.out.println("==================");
            for (int j = 0; j < current.length; j++) {
                String[] wordForms = current[j].getWordForms();
                for (int k = 0; k < wordForms.length; k++) {
                    System.out.println(wordForms[k]);
                }
            }
        }
    }


//    public class AnalyzedDBObject extends BasicDBObject {
//        public static enum Condition {ALL,IN}
//        private Analyzer analyzer;
//
//        public AnalyzedDBObject(Analyzer analyzer) {
//            this.analyzer = analyzer;
//        }
//
//        public AnalyzedDBObject appendAndAnalyzeFullText(String name, String text)
//                throws IOException {
//            append(name, tokenize(analyzer.tokenStream(name, new StringReader(text))));
//            return this;
//        }
//
//        private List<string> tokenize(TokenStream stream) throws IOException {
//            List<string> tokens = new ArrayList<string>();
//            TermAttribute term = (TermAttribute) stream
//                    .addAttribute(TermAttribute.class);
//            while (stream.incrementToken()) {
//                // Not sure if we somehow can use termBuffer() to get a char[]
//                // so we do no have to create a new String for each term
//                tokens.add(term.term());
//            }
//            return tokens;
//        }
//    }
//    public class AnalyzedDBObject extends BasicDBObject {
//        public static enum Condition {ALL,IN}
//        private Analyzer analyzer;
//
//        public AnalyzedDBObject(Analyzer analyzer) {
//            this.analyzer = analyzer;
//        }
//
////        public AnalyzedDBObject appendAndAnalyzeFullText(String name, String text)
////                throws IOException {
////            append(name, tokenize(analyzer.tokenStream(name, new StringReader(text))));
////            return this;
////        }
//
//        private List<String> tokenize(TokenStream stream) throws IOException {
//            List<String> tokens = new ArrayList<String>();
//            TermAttribute term = (TermAttribute) stream
//                    .addAttribute(TermAttribute.class);
//            while (stream.incrementToken()) {
//                // Not sure if we somehow can use termBuffer() to get a char[]
//                // so we do no have to create a new String for each term
//                tokens.add(term.term());
//            }
//            return tokens;
//        }
//    }
}
