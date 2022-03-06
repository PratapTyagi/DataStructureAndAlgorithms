public class UnboundedImplementation {
    static int solve(int[] wt, int[] val, int W, int n, int[][] dp) {
        if (n == 0 || W == 0)
            return 0;

        if (dp[n - 1][W] != -1)
            return dp[n - 1][W];

        if (wt[n - 1] <= W)
            return dp[n - 1][W] = Math.max(val[n - 1] + solve(wt, val, W - wt[n - 1], n, dp),
                    solve(wt, val, W, n - 1, dp));
        else
            return dp[n - 1][W] = solve(wt, val, W, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] wt = new int[] { 1, 50 };
        int[] val = new int[] { 1, 30 };
        int W = 100;
        int[][] dp = new int[wt.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        int value = solve(wt, val, W, wt.length, dp);
        System.out.println(value);
    }
}
