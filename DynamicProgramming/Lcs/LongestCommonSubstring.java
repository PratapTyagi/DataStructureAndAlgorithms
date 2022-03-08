public class LongestCommonSubstring {
    static int find(String a, String b, int m, int n, int count, int[][] dp) {
        if (m == 0 || n == 0)
            return dp[m][n] = count;

        if (a.charAt(m - 1) == b.charAt(n - 1))
            count = find(a, b, m - 1, n - 1, count + 1, dp);
        count = Math.max(Math.max(find(a, b, m, n - 1, 0, dp), find(a, b, m - 1, n, 0, dp)), count);
        return dp[m][n] = count;
    }

    public static void main(String[] args) {
        String str1 = "abcdegh";
        String str2 = "abcdeh";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        System.out.println(find(str1, str2, str1.length(), str2.length(), 0, dp));
    }
}
