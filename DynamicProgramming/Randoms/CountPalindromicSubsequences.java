public class CountPalindromicSubsequences {
    static int mod = 1000000007;

    static long cps(String a, int i, int j, long[][] dp) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (a.charAt(i) == a.charAt(j))
            return dp[i][j] = (1 + cps(a, i + 1, j, dp) % mod + cps(a, i, j - 1, dp) % mod) % mod;
        else
            return dp[i][j] = (mod + cps(a, i + 1, j, dp) % mod + cps(a, i, j - 1, dp) % mod
                    - cps(a, i + 1, j - 1, dp) % mod) % mod;
    }

    static long countPS(String s) {
        int n = s.length();
        long[][] dp = new long[n + 1][n + 1];

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        long cpsValue = cps(s, 0, n - 1, dp);
        return (cpsValue) % mod;
    }

    public static void main(String[] args) {
        System.out.println(countPS("abcd"));
    }
}
