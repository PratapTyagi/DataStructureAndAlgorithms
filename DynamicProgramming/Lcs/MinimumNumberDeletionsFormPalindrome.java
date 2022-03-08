public class MinimumNumberDeletionsFormPalindrome {
    static int find(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return m - dp[m][n];
    }

    public static void main(String[] args) {
        String a = "aebcbda";
        StringBuilder sb = new StringBuilder(a);

        System.out.println(find(a, sb.reverse().toString(), a.length(), a.length()));
    }
}
