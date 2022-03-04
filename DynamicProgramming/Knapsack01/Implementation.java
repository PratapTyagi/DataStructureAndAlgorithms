package DynamicProgramming.Knapsack01;

public class Implementation {
    static int solve(int[] wt, int[] val, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != 0) {
            return dp[n][W];
        }

        if (wt[n] <= W) {
            return dp[n][W] = Math.max(val[n] + solve(wt, val, W - wt[n], n - 1, dp), solve(wt, val, W, n - 1, dp));
        } else {
            return dp[n][W] = solve(wt, val, W, n - 1, dp);
        }
    }

    public static void main(String[] args) {
        int[] wt = new int[] { 25, 20, 30 };
        int[] val = new int[] { 20, 25, 40 };
        int W = 50;
        int[][] dp = new int[wt.length + 1][W + 1];
        int value = solve(wt, val, W, wt.length - 1, dp);
        System.out.println(value);
    }
}