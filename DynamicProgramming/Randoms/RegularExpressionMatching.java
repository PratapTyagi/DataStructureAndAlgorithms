public class RegularExpressionMatching {
    static boolean matchingUtil(String str, String pat) {
        boolean[][] dp = new boolean[pat.length() + 1][str.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j == 0) {
                    char patChar = pat.charAt(i - 1);
                    if (patChar == '*')
                        dp[i][j] = dp[i - 2][j];
                    else
                        dp[i][j] = false;
                } else {
                    char patChar = pat.charAt(i - 1);
                    char strChar = str.charAt(j - 1);

                    if (patChar == '*') {
                        dp[i][j] = dp[i - 2][j];

                        char patSecondLastChar = pat.charAt(i - 2);
                        if (patSecondLastChar == '.' || patSecondLastChar == strChar)
                            dp[i][j] = dp[i][j] || dp[i][j - 1];
                    } else if (patChar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (strChar == patChar) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else
                        dp[i][j] = false;
                }
            }
        }

        return dp[pat.length()][str.length()];
    }

    public static void main(String[] args) {
        String str = "mississippi";
        String pat = "mis*i*p*i";

        System.out.println(matchingUtil(str, pat));
    }
}
