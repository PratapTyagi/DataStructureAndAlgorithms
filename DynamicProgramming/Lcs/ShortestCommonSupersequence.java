public class ShortestCommonSupersequence {
    static int lcs(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    static int find(String a, String b, int m, int n) {
        int lcsValue = lcs(a, b, m, n);
        return (m + n - lcsValue);
    }

    public static void main(String[] args) {
        String a = "efgh";
        String b = "jghi";

        System.out.println(find(a, b, a.length(), b.length()));
    }
}
