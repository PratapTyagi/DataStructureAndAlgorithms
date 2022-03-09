public class MatrixChainMultiplication {
    static int find(int[] arr, int i, int j, int ans, int[][] dp) {
        if (i >= j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        for (int k = i; k < j; k++) {
            int temp = find(arr, i, k, ans, dp) + find(arr, k + 1, j, ans, dp) + (arr[i - 1] * arr[k] * arr[j]);
            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }

    static int matrixMultiplication(int n, int arr[]) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return find(arr, 1, n - 1, Integer.MAX_VALUE, dp);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 40, 20, 30, 10, 30 };
        System.out.println(matrixMultiplication(arr.length, arr));
    }
}
