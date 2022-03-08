public class PrintLongestCommonSubsequence {
    static void find(String a, String b, int m, int n, int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j] > dp[i - 1][j])
                    j--;
                else
                    i--;
            }
        }

        System.out.println(sb.reverse().toString());
    }

    public static void main(String[] args) {
        String str1 = "abcdegh";
        String str2 = "abcdeh";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        find(str1, str2, str1.length(), str2.length(), dp);
    }
}
