public class EqualSumPartitionTopDown {
    static boolean isPossible(int[] arr, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = 0;
                if (j == 0)
                    dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = (dp[i - 1][j] != 0 || dp[i - 1][j - arr[i - 1]] != 0) ? 1 : 0;
                else
                    dp[i][j] = 0;
            }
        }
        return dp[n][sum] == 1 ? true : false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 3, 8, 0 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }
        boolean res = isPossible(arr, sum / 2, arr.length);
        System.out.println(res);
    }
}
