package core;

/**
 * Created by Pyrozhok on 27.05.2016.
 */
public class Shingle {

    private Word[] words;
    private int size;
    private String term;
    private String[] hashes;

    public Shingle(Word[] words) {
        this.words = words;
        size = words.length;
        term = "";
        for (int i = 0; i < size; i++) {
            term += words[i].getActual() + " ";
        }

        //TODO hashing
    }

    @Override
    public String toString() {
        return this.term;
    }
}
