package core;

/**
 * Created by Pyrozhok on 27.05.2016.
 */
public class Algorithmizer {

    public Shingle[] shinglesAlgorithm(int shingleSize, Word[] words) {
        int shinglesCount = words.length / shingleSize;
        if (words.length % shingleSize != 0) {
            shinglesCount++;
        }
        Shingle[] shingles = new Shingle[shinglesCount];
        for (int i = 0; i < shinglesCount; i++) {
            Word[] wordsToAdd = new Word[shingleSize];
            for (int j = 0; j < shingleSize; j++) {
                int index = shingleSize * i + j;
                if (index >= words.length) {
                    index -= words.length;
                }
                wordsToAdd[j] = words[index];
            }
            shingles[i] = new Shingle(wordsToAdd);
        }
        return shingles;
    }
}
