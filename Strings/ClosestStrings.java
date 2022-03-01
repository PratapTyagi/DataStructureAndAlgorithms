package Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestStrings {
    static int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int first = -1, second = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).equals(word1)) {
                first = i;
            }
            if (s.get(i).equals(word2)) {
                second = i;
            }
            if (first != -1 && second != -1) {
                min = Math.min(min, Math.abs(first - second));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>(Arrays.asList("the", "quick", "brown", "fox", "quick"));
        String word2 = "the";
        String word1 = "fox";

        System.out.println(shortestDistance(s, word1, word2));
    }
}
