package core;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import utils.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class Lemmatizer {

    private StanfordCoreNLP pipeline;

    public Lemmatizer() {
        Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        this.pipeline = new StanfordCoreNLP(props);
    }

    public String lemmatize(String word) {
        // Create an empty Annotation just with the given text
        Annotation entry = new Annotation(word);
        // run all Annotators on this text
        this.pipeline.annotate(entry);
        List<CoreLabel> tokens = (entry.get(CoreAnnotations.TokensAnnotation.class));
        if (tokens.size() > 1) {
            Logger.warning("Lots of tokens [" + word + "]");
        }
        return tokens.get(0).get(CoreAnnotations.LemmaAnnotation.class);
    }
}
