import java.util.HashMap;

public class LongestKUniqueCharactersSubstring {
    static int longestkSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = -1;

        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() < k)
                j++;
            else if (map.size() > k) {
                while (map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String S = "aabacbebebe";
        int K = 3;
        System.out.println(longestkSubstr(S, K));
    }
}