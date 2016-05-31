package core;

import utils.StringMan;

import java.util.Arrays;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Pyrozhok on 27.05.2016.
 */
public class Algorithmizer {

    public Shingle[] shinglesAlgorithm(int shingleLength, Word[] words, int commonWordsInNeighbourShingles) {
        assertTrue(shingleLength < words.length, "Shingle length can not be larger than words.length");
        assertNotEquals(shingleLength, commonWordsInNeighbourShingles, "Shingle length and common words var can not be equal");
        int shinglesCount = (words.length - shingleLength) / (shingleLength - commonWordsInNeighbourShingles) + 1;
        if ((words.length - shingleLength) % (shingleLength - commonWordsInNeighbourShingles) != 0) {
            shinglesCount++;
        }
        Shingle[] shingles = new Shingle[shinglesCount];
        for (int i = 0; i < shinglesCount; i++) {
            Word[] wordsToAdd = new Word[shingleLength];
            for (int j = 0; j < shingleLength; j++) {
                int index = i * (shingleLength - commonWordsInNeighbourShingles) + j;
                if (index >= words.length) {
                    index -= words.length;
                }
                wordsToAdd[j] = words[index];
            }
            wordsToAdd = StringMan.alphabeticalSort(wordsToAdd);
            shingles[i] = new Shingle(wordsToAdd);
        }
        return shingles;
    }

    public double getShinglesRatio(Shingle[] source1, Shingle[] source2) {
        Shingle[] smaller;
        Shingle[] bigger;
        if (source1.length <= source2.length) {
            smaller = source1;
            bigger = source2;
        }
        else {
            smaller = source2;
            bigger = source2;
        }

        int sameCounter = 0;
        for (int i = 0; i < smaller.length; i++) {
            if (Arrays.asList(bigger).contains(smaller[i])) {
                sameCounter++;
            }
        }
        return sameCounter / smaller.length;
    }
}
