import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pyrozhok on 23.05.2016.
 */
public class Normalizer {

    private String originalText;

    private String stopWords = "or\n" +
            "this\n" +
            "no\n" +
            "yes\n" +
            "contrary\n" +
            "about\n" +
            "therefore\n" +
            "during\n" +
            "beyond\n" +
            "nearby\n" +
            "without\n" +
            "via\n" +
            "otherwise\n" +
            "moreover\n" +
            "thus\n" +
            "above\n" +
            "then\n" +
            "beside\n" +
            "even\n" +
            "near\n" +
            "per\n" +
            "between\n" +
            "in\n" +
            "considering\n" +
            "past\n" +
            "opposite\n" +
            "underneath\n" +
            "as\n" +
            "toward\n" +
            "at\n" +
            "hence\n" +
            "among\n" +
            "following\n" +
            "failing\n" +
            "aboard\n" +
            "except\n" +
            "if\n" +
            "finally\n" +
            "besides\n" +
            "against\n" +
            "still\n" +
            "worth\n" +
            "across\n" +
            "into\n" +
            "by\n" +
            "unlike\n" +
            "nonetheless\n" +
            "alongside\n" +
            "within\n" +
            "excepting\n" +
            "amid\n" +
            "indeed\n" +
            "astride\n" +
            "off\n" +
            "the\n" +
            "when\n" +
            "meanwhile\n" +
            "after\n" +
            "atop\n" +
            "to\n" +
            "so\n" +
            "under\n" +
            "likewise\n" +
            "but\n" +
            "through\n" +
            "once\n" +
            "inside\n" +
            "upon\n" +
            "down\n" +
            "circa\n" +
            "amongst\n" +
            "anyway\n" +
            "excluding\n" +
            "than\n" +
            "nevertheless\n" +
            "from\n" +
            "up\n" +
            "unless\n" +
            "though\n" +
            "wherever\n" +
            "beneath\n" +
            "including\n" +
            "below\n" +
            "like\n" +
            "however\n" +
            "towards\n" +
            "onto\n" +
            "plus\n" +
            "regarding\n" +
            "furthermore\n" +
            "nor\n" +
            "because\n" +
            "aside\n" +
            "consequently\n" +
            "and\n" +
            "outside\n" +
            "now\n" +
            "accordingly\n" +
            "before\n" +
            "next\n" +
            "behind\n" +
            "instead\n" +
            "for\n" +
            "yet\n" +
            "what\n" +
            "around\n" +
            "whether\n" +
            "times\n" +
            "along\n" +
            "throughout\n" +
            "since\n" +
            "namely\n" +
            "whenever\n" +
            "until\n" +
            "on\n" +
            "that\n" +
            "over\n" +
            "unto\n" +
            "barring\n" +
            "although\n" +
            "while\n" +
            "despite\n" +
            "versus\n" +
            "with\n" +
            "till\n" +
            "concerning\n" +
            "round\n" +
            "far\n" +
            "of\n" +
            "also\n" +
            "is\n" +
            "are\n" +
            "been\n" +
            "was\n" +
            "were";

//    @Test
//    public void test() {
//        List<String> stopWordsList = new ArrayList<String>(Arrays.asList(stopWords.split("\\s")));
//        System.out.println(stopWordsList.contains("were"));
//    }

    public Normalizer(String text) {
        this.originalText = text;
    }

    public String getOriginalText() {
        return this.originalText;
    }

    public String[] normalize() {
        List<String> words = Arrays.asList(this.originalText.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"));
        List<String> stopWordsList = new ArrayList<String>(Arrays.asList(stopWords.split("\\s")));
        List<String> wordsAfterCleaning = new ArrayList<String>();
        for (String word : words) {
            boolean isAllowed = !((word.length() == 1) || (stopWordsList.contains(word)));
            if (isAllowed) {
                wordsAfterCleaning.add(word);
            }
        }
        String[] result = new String[wordsAfterCleaning.size()];
        for (int i = 0; i < wordsAfterCleaning.size(); i++) {
            result[i] = wordsAfterCleaning.get(i);
        }
        return result;
    }
}
