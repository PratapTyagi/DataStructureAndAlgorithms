public class LongestCommonSubsequence {
    static int find(String a, String b, int n, int m, int[][] dp) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n - 1][m - 1] != -1)
            return dp[n - 1][m - 1];

        if (a.charAt(n - 1) == b.charAt(m - 1))
            return dp[n - 1][m - 1] = 1 + find(a, b, n - 1, m - 1, dp);
        else
            return dp[n - 1][m - 1] = Math.max(find(a, b, n - 1, m, dp), find(a, b, n, m - 1, dp));
    }

    public static void main(String[] args) {
        String str1 = "abcdegh";
        String str2 = "abcdeh";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        System.out.println(find(str1, str2, str1.length(), str2.length(), dp));
    }
}