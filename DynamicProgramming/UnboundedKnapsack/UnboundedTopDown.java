public class UnboundedTopDown {
    static int solve(int[] wt, int[] val, int W, int n, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                else if (wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = new int[] { 1, 50 };
        int[] val = new int[] { 1, 30 };
        int W = 100;
        int[][] dp = new int[wt.length + 1][W + 1];
        int value = solve(wt, val, W, wt.length, dp);
        System.out.println(value);
    }
}
