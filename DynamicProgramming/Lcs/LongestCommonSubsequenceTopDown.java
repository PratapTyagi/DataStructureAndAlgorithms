public class LongestCommonSubsequenceTopDown {
    static int find(String a, String b, int n, int m, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "GEBEOCFUFTSXDIXTIGSIEEHKCHZ";
        String str2 = "DFLILRJQFNXZ";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        System.out.println(find(str1, str2, str1.length(), str2.length(), dp));
    }
}