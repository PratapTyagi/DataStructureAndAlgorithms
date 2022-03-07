// minimum no. of coins to form a sum
public class CoinChangeProblem2 {
    static int find(int[] arr, int sum, int n, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
                if (j == 0)
                    dp[i][j] = 0;
                else if (i == 1 && j > 0) {
                    if (j % arr[i - 1] == 0)
                        dp[i][j] = j / arr[i - 1];
                    else
                        dp[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - arr[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
    }

    public static void main(String[] args) {
        int N = 15;
        int[] S = new int[] { 4 };

        int dp[][] = new int[S.length + 1][N + 1];

        int otp = find(S, N, S.length, dp);
        System.out.println(otp == Integer.MAX_VALUE - 1 ? -1 : otp);
    }
}
