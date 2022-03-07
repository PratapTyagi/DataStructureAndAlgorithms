public class CoinChangeProblem1 {
    static long find(int arr[], int sum, int n, long[][] dp) {
        if (sum == 0)
            return 1;
        if (n <= 0)
            return 0;

        if (dp[n - 1][sum] != -1)
            return dp[n - 1][sum];

        if (arr[n - 1] <= sum)
            return dp[n - 1][sum] = find(arr, sum - arr[n - 1], n, dp) + find(arr, sum, n - 1, dp);
        else
            return dp[n - 1][sum] = find(arr, sum, n - 1, dp);
    }

    public static void main(String[] args) {
        int N = 4;
        int[] S = new int[] { 1, 2, 3 };

        long dp[][] = new long[S.length + 1][N + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        System.out.println(find(S, N, S.length, dp));
    }
}
