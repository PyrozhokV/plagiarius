package core;

/**
 * Created by Pyrozhok on 25.05.2016.
 */
public class Word implements Comparable<Word> {

    private String original;
    private String[] synonyms;
    private String actual;
    private int originalTF;

    public Word(String original) {
        this.original = original;
    }

    public void setActual(String actual) {
        this.actual = actual.toLowerCase();
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    public void setOriginalTF(int frequency) {
        this.originalTF = frequency;
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

    public int getOriginalTF() {
        return originalTF;
    }

    @Override
    public String toString() {
        return this.actual;
    }

    @Override
    public int compareTo(Word o) {
        return this.actual.compareTo(o.actual);
    }
}
