import java.util.Arrays;

public class OptimalStrategyForGame {
    static long helper(int[] arr, int i, int n, long[][] dp) {
        if (i > n)
            return 0;
        if (i == n)
            return arr[i];
        if (dp[i][n] != -1)
            return dp[i][n];

        long val1 = arr[i] + Math.min(helper(arr, i + 1, n - 1, dp), helper(arr, i + 2, n, dp));
        long val2 = arr[n] + Math.min(helper(arr, i + 1, n - 1, dp), helper(arr, i, n - 2, dp));
        return dp[i][n] = Math.max(val1, val2);
    }

    // Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n) {
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        return helper(arr, 0, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] arr = { 8, 15, 3, 7 };
        System.out.println(countMaximum(arr, arr.length));
    }
}