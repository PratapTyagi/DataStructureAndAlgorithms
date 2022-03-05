public class SubsetSumTopDown {
    static boolean isSum(int[] set, int sum, int n, boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0)
                    dp[i][j] = true;
                if (i == 0 && j >= 1)
                    dp[i][j] = false;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (set[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int set[] = new int[] { 57, 68, 27, 100, 69, 49, 100, 51, 71, 63, 77, 20, 63, 4, 11, 31, 21, 23, 94, 5, 56, 54,
                15, 88, 61, 89, 5, 22, 83, 55, 90, 39, 74, 16, 38, 42, 17, 37, 93, 39, 52, 69, 59, 14, 24, 21, 96, 96,
                43, 89, 100, 51, 95, 15, 38, 7, 55, 42, 28, 37, 49, 69, 75, 74, 36, 12, 16, 52, 1, 60, 43, 52, 80, 53,
                65, 55, 73, 12, 50, 68, 100, 50, 18, 94, 16, 7, 100, 70, 1, 79, 58, 49, 47, 32, 74, 35, 95, 89, 38,
                47 };
        int sum = 5142;
        boolean[][] dp = new boolean[set.length + 1][sum + 1];
        System.out.println(isSum(set, sum, set.length, dp));
    }
}
