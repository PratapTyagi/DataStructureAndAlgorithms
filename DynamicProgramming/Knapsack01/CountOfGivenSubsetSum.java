package DynamicProgramming.Knapsack01;

public class CountOfGivenSubsetSum {
    static int calculate(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }

        if (dp[n - 1][sum] != -1)
            return dp[n - 1][sum];

        if (arr[n - 1] <= sum)
            return dp[n - 1][sum] = (calculate(arr, sum, n - 1, dp) + calculate(arr, sum - arr[n - 1], n - 1, dp))
                    % 1000000007;
        else
            return dp[n - 1][sum] = calculate(arr, sum, n - 1, dp) % 1000000007;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 6, 10, 1, 4, 7, 1, 9, 5, 10, 5, 3, 5, 10, 1, 5, 4, 4, 3, 8, 10, 10, 7, 4, 1, 6, 7, 6, 6,
                8, 3, 4, 4, 2, 7, 7, 1, 9, 6, 5, 9, 10, 9, 5, 1, 2, 2, 4, 5, 4, 3, 4, 5, 9, 10, 8, 4, 6, 3, 1, 5, 8, 7,
                8, 9, 3, 5, 1, 1, 2, 5, 1, 3, 6, 8, 3, 7, 9, 8, 3, 4, 2, 8, 8, 10, 7, 7, 5, 4, 2, 8, 9, 9, 4, 6, 7, 8 };
        int sum = 185;
        // 175398726
        int[][] dp = new int[arr.length + 1][sum + 1];

        int count = 0;
        int zeros = 1;
        for (int i = 0; i < arr.length - count; i++)
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - count];
                arr[arr.length - 1 - count] = temp;
                count++;
                zeros = (zeros * 2) % 1000000007;
            }

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        System.out.println(calculate(arr, sum, arr.length - count, dp) * (zeros));
    }
}
