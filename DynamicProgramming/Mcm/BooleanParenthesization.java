import java.util.HashMap;

public class BooleanParenthesization {
    static int find(String s, int i, int j, boolean isTrue, HashMap<String, Integer> dp) {
        if (i > j)
            return 0;

        String temp = i + "" + j + "" + isTrue + "";
        if (dp.containsKey(temp) != false)
            return dp.get(temp) % 1003;

        if (i == j) {
            if (isTrue == true)
                return s.charAt(i) == 'T' ? 1 : 0;
            else
                return s.charAt(i) == 'F' ? 1 : 0;
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int lf = find(s, i, k - 1, false, dp);
            int lt = find(s, i, k - 1, true, dp);
            int rf = find(s, k + 1, j, false, dp);
            int rt = find(s, k + 1, j, true, dp);

            if (s.charAt(k) == '&') {
                if (isTrue)
                    ans += lt * rt;
                else
                    ans += lt * rf + lf * rt + lf * rf;
            } else if (s.charAt(k) == '|') {
                if (isTrue)
                    ans += lt * rf + lf * rt + lt * rt;
                else
                    ans += lf * rf;
            } else if (s.charAt(k) == '^') {
                if (isTrue)
                    ans += lt * rf + lf * rt;
                else
                    ans += lt * rt + lf * rf;
            }
        }
        dp.put(temp, ans);
        return ans % 1003;
    }

    static int countWays(int n, String s) {
        HashMap<String, Integer> map = new HashMap<>();
        return find(s, 0, n - 1, true, map);
    }

    public static void main(String[] args) {
        String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
        System.out.println(countWays(s.length(), s));
    }
}