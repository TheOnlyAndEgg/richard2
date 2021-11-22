package richard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

    private static final HashMap<String, Double> sentimentVals = new HashMap<>();
    private static final ArrayList<String> posAdjectives = new ArrayList<>();
    private static final ArrayList<String> negAdjectives = new ArrayList<>();

    private static final String SPACE = " ";

    public static void main(String[] args) {
        readSentimentCsv();
        initializeAdjectiveLists();

        System.out.println(Review.totalSentiment("review.txt"));
        System.out.println(Review.starRating("review.txt"));
    }

    /**
     * Read cleanSentiment.csv
     */
    public static void readSentimentCsv() {
        String csv = textToString("cleanSentiment.csv");
        String[] lines = csv.split("\n");

        for (String line : lines) {
            String[] values = line.split(",");
            String word = values[0];
            double sentimentValue = Double.parseDouble(values[1]);

            sentimentVals.put(word, sentimentValue);
        }
    }

    /**
     * Generate posAdjectives and negAdjectives from the sentimentVals map
     */
    public static void initializeAdjectiveLists() {
        for (Map.Entry<String, Double> entry : sentimentVals.entrySet()) {
            String word = entry.getKey();
            double sentimentVal = entry.getValue();

            if (sentimentVal > 0) {
                posAdjectives.add(word);
            } else {
                negAdjectives.add(word);
            }
        }
    }

    /**
     * @return a string containing the text in fileName
     */
    public static String textToString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
     */
    public static double sentimentVal(String word) {
        return sentimentVals.getOrDefault(word.toLowerCase(), 0d);
    }

    /**
     * Returns the ending punctuation of a string, or the empty string if there is none
     */
    public static String getPunctuation(String word) {
        String punc = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(word.charAt(i))) {
                punc = punc + word.charAt(i);
            } else {
                return punc;
            }
        }
        return punc;
    }

    /**
     * Returns the word after removing any beginning or ending punctuation
     */
    public static String removePunctuation(String word) {
        while (word.length() > 0 && !Character.isAlphabetic(word.charAt(0))) {
            word = word.substring(1);
        }
        while (word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length() - 1))) {
            word = word.substring(0, word.length() - 1);
        }

        return word;
    }

    /**
     * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
     */
    public static String randomPositiveAdj() {
        int index = (int) (Math.random() * posAdjectives.size());
        return posAdjectives.get(index);
    }

    /**
     * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
     */
    public static String randomNegativeAdj() {
        int index = (int) (Math.random() * negAdjectives.size());
        return negAdjectives.get(index);
    }

    /**
     * Randomly picks a positive or negative adjective and returns it.
     */
    public static String randomAdjective() {
        if (Math.random() < .5) {
            return randomPositiveAdj();
        } else {
            return randomNegativeAdj();
        }
    }

    public static double totalSentiment(String fileName) {
        double n = 0.0;
        String textFile = textToString(fileName);
        String[] words = textFile.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = removePunctuation(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            n += sentimentVal(words[i]);

        }
        return n;

    }

    public static double starRating(String fileName) {
        double reviewSent = totalSentiment(fileName);
        if (reviewSent > 50) {
            return 5;

        } else if (reviewSent < 50 && reviewSent > 25) {
            return 4;
        } else if (reviewSent < 25 && reviewSent > 10){
            return 3;
        } else if (reviewSent < 10 && reviewSent > 0) {
            return 2;
        } else {
            return 1;
        }
    }

}