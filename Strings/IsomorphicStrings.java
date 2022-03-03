package Strings;

import java.util.*;

public class IsomorphicStrings {
    static boolean isIsomorphic(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i)) && map.get(a.charAt(i)) != b.charAt(i)) {
                return false;
            }
            if (!map.containsKey(a.charAt(i))) {
                if (map.containsValue(b.charAt(i))) {
                    return false;
                }
                map.put(a.charAt(i), b.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "pijthbsfy";
        String str2 = "fvladzpbf";

        System.out.println(isIsomorphic(str1, str2));
    }
}
