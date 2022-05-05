import java.util.HashMap;

public class SmallestWindowInStringContainingAllCharactersOfAnotherString {
    static String smallestWindow(String s, String p) {
        if (p.length() > s.length()) {
            return "-1";
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int desiredLength = p.length(), matchedCount = 0;
        int i = 0, j = 0;
        int n = s.length();

        for (int k = 0; k < desiredLength; k++) {
            char c = p.charAt(k);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        String ans = "-1";
        while (true) {
            boolean flag1 = false, flag2 = false;
            // Acquire characters
            while (i < n && desiredLength > matchedCount) {
                char c = s.charAt(i);
                map1.put(c, map1.getOrDefault(c, 0) + 1);
                if (map1.getOrDefault(c, 0) <= map2.getOrDefault(c, 0))
                    matchedCount++;
                i++;
                flag1 = true;
            }

            // Process and release
            while (j < i && desiredLength == matchedCount) {
                if (matchedCount == desiredLength) {
                    String probableAns = s.substring(j, i);
                    if (ans.equals("-1") || probableAns.length() < ans.length())
                        ans = probableAns;
                }

                char c = s.charAt(j);
                int charValue = map1.getOrDefault(c, 0);
                if (charValue == 1)
                    map1.remove(c);
                else
                    map1.put(c, charValue - 1);

                if (charValue - 1 < map2.getOrDefault(c, Integer.MIN_VALUE))
                    matchedCount--;
                j++;
                flag2 = true;
            }
            if (flag1 == false && flag2 == false)
                break;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "zoomlazapzo", p = "oza";
        System.out.println(smallestWindow(s, p));
    }
}
