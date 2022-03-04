package DynamicProgramming.Knapsack01;

public class TopDownImplementation {
    static int solve(int[] wt, int[] val, int W, int n, int[][] dp) {
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = new int[] { 25, 20, 30 };
        int[] val = new int[] { 20, 25, 40 };
        int W = 50;
        int[][] dp = new int[wt.length + 1][W + 1];
        int value = solve(wt, val, W, wt.length, dp);
        System.out.println(value);
    }
}
