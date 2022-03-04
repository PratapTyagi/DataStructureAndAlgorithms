package DynamicProgramming.Knapsack01;

public class EqualSumPartition {
    static int isPossible(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0)
            return 1;
        if (n <= 0)
            return 0;

        if (dp[n - 1][sum] != -1) {
            return dp[n - 1][sum];
        }

        if (arr[n - 1] <= sum)
            return dp[n - 1][sum] = (isPossible(arr, sum, n - 1, dp) != 0
                    || isPossible(arr, sum - arr[n - 1], n - 1, dp) != 0) ? 1 : 0;
        else
            return dp[n - 1][sum] = isPossible(arr, sum, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 3, 7, 0 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }

        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++)
            for (int j = 0; j <= sum; j++)
                dp[i][j] = -1;

        int res = isPossible(arr, sum / 2, arr.length, dp);
        System.out.println(res == 1 ? true : false);
    }
}
