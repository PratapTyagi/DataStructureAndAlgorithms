public class PalindromicPatitioning {
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int find(String s, int i, int j, int ans, int[][] dp) {
        if (i >= j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (isPalindrome(s, i, j))
            return 0;

        for (int k = i; k < j; k++) {
            int temp = find(s, i, k, ans, dp) + find(s, k + 1, j, ans, dp) + 1;
            ans = Math.min(temp, ans);
        }
        return dp[i][j] = ans;
    }

    static int palindromicPartition(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return find(s, 0, n - 1, Integer.MAX_VALUE, dp);
    }

    public static void main(String[] args) {
        String s = "aaabba";
        System.out.println(palindromicPartition(s));
    }
}
