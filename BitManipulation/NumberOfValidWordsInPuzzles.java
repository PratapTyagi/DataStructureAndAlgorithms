import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class NumberOfValidWordsInPuzzles {
    /*
     * 1. You are given N number of words.
     * 2. You are given M puzzles in the form of M strings.
     * 3. For a given puzzle, a word is valid if both the following conditions are
     * confirmed -
     * Condition 1 -> Word contains the first letter of puzzle.
     * Condition 2 -> For each letter in word, that letter should be present in
     * puzzle.
     * 4. You have to print the number of valid words corresponding to a puzzle.
     */

    static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < 26; i++)
            map.put((char) (i + 'a'), new ArrayList<>());

        // assigning masks corresponding to words to each character of the word
        for (String word : words) {
            int mask = 1;
            for (char c : word.toCharArray()) {
                int charPlace = c - 'a';
                mask = mask | (1 << charPlace);
            }

            HashSet<Character> unique = new HashSet<>();
            for (char c : word.toCharArray()) {
                if (unique.contains(c))
                    continue;
                unique.add(c);
                map.get(c).add(mask);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            char firstChar = puzzle.charAt(0);
            ArrayList<Integer> wordsList = map.get(firstChar);

            int puzzleMask = 1;
            for (char c : puzzle.toCharArray()) {
                int charPlace = c - 'a';
                puzzleMask = puzzleMask | (1 << charPlace);
            }

            int count = 0;
            for (Integer wordMask : wordsList) {
                // it is to check 2nd condition of ques
                if ((wordMask & puzzleMask) == wordMask)
                    count++;
            }
            res.add(count);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0; i < m; i++) {
            puzzles[i] = scn.next();
        }
        scn.close();
        ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
        for (int i = 0; i < m; i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }
}
