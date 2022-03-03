package Strings;

import java.util.HashMap;
import java.util.Map;

public class PanagramChecking {
    static boolean check(String s) {
        s = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabets.length(); i++)
            map.put(alphabets.charAt(i), 1);

        for (int i = 0; i < s.length(); i++)
            if (map.containsKey(s.charAt(i)))
                map.remove(s.charAt(i));

        if (map.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "Bawds jog, flick quartz, vex nymph";
        System.out.println(check(s));
    }
}
