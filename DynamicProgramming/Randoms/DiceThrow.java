import java.util.HashMap;

class DiceThrow {
    static long solve(int m, int n, int x, HashMap<String, Long> map) {
        if (n == 0 && x == 0)
            return 1;
        if (n == 0)
            return 0;

        if (map.containsKey(n + "," + x))
            return map.get(n + "," + x);

        long res = 0;
        for (int i = 1; i <= m && x >= i; i++)
            res += solve(m, n - 1, x - i, map);
        map.put(n + "," + x, res);
        return res;
    }

    static long noOfWays(int m, int n, int x) {
        // HashMap<String, Long> map = new HashMap<>();
        // return solve(m, n, x, map);
        long[][] dp = new long[n + 1][x + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++)
                for (int k = 1; k <= m && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];
        }

        return dp[n][x];
    }

    public static void main(String[] args) {
        int M = 6, N = 3, X = 12;
        System.out.println(noOfWays(M, N, X));
    }
}