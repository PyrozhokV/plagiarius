package core;

import utils.StringMan;

/**
 * Created by Pyrozhok on 27.05.2016.
 */
public class Shingle {

    private Word[] words;
    private int size;
    private String term;
    private String hash;
    private int tf;

    public Shingle(Word[] words) {
        this.words = words;
        size = words.length;
        term = "";
        for (int i = 0; i < size; i++) {
            term += words[i].getActual() + " ";
        }
        hash = StringMan.getHashSHA256(term);
    }

    public String getHash() {
        return hash;
    }

    public void setTF(int tf) {
        this.tf = tf;
    }

    public int getTf() {
        return tf;
    }

    @Override
    public String toString() {
        return this.term;
    }
}
