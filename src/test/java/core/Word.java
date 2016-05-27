package core;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class Word {

    private String original;
    private String[] synonyms;
    private String actual;
    private int originalTermFrequency;

    public Word(String original) {
        this.original = original;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    public void setOriginalTermFrequency(int frequency) {
        this.originalTermFrequency = frequency;
    }

    public String getOriginal() {
        return original;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public String getActual() {
        return actual;
    }

    public int getOriginalTermFrequency() {
        return originalTermFrequency;
    }

    @Override
    public String toString() {
        return this.actual;
    }
}
