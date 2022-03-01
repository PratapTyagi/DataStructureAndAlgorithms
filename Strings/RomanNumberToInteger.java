package Strings;

import java.util.HashMap;

public class RomanNumberToInteger {
    static int romanToDecimal(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0, prev = 0;
        for (int i = 0; i < str.length(); i++) {
            int current = map.get(str.charAt(i));
            if (prev < current) {
                ans -= 2 * prev;
            }
            prev = current;
            ans += current;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "CMXVI";
        System.out.println(romanToDecimal(s));
    }
}
