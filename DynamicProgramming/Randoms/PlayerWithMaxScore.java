import java.util.Arrays;

public class PlayerWithMaxScore {
    static int helper(int[] arr, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (i == j)
            return arr[j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int val1 = arr[i] + Math.min(helper(arr, i + 1, j - 1, dp), helper(arr, i + 2, j, dp));
        int val2 = arr[j] + Math.min(helper(arr, i + 1, j - 1, dp), helper(arr, i, j - 2, dp));

        return dp[i][j] = Math.max(val1, val2);
    }

    static boolean is1winner(int n, int arr[]) {
        int sum = 0;
        for (int e : arr)
            sum += e;

        int[][] dp = new int[1002][1002];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        int res = helper(arr, 0, n - 1, dp);
        return res > sum - res ? true : false;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 3 };
        System.out.println(is1winner(arr.length, arr));
    }
}
