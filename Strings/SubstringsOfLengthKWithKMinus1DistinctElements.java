import java.util.HashMap;

public class SubstringsOfLengthKWithKMinus1DistinctElements {
    static int countOfSubstrings(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int n = s.length();
        int res = 0;

        // Using sliding window
        // Traverse string
        while (i < n) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (i - j + 1 >= k) {
                if (map.size() == k - 1)
                    res++;
                if (map.get(s.charAt(j)) == 1)
                    map.remove(s.charAt(j));
                else
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                j++;
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "aabab";
        int K = 3;

        System.out.println(countOfSubstrings(S, K));
    }
}