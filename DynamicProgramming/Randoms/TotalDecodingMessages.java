public class TotalDecodingMessages {
    static int countWays(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0')
            return 0;

        int mod = 1000000007;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0')
                dp[i] = 0;
            else if (s.charAt(i - 1) == '0' && s.charAt(i) != '0')
                dp[i] = dp[i - 1] % mod;
            else if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    dp[i] = (i >= 2 ? dp[i - 2] % mod : 1);
                else
                    dp[i] = 0;
            } else {
                if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26)
                    dp[i] = (dp[i - 1] % mod + (i >= 2 ? dp[i - 2] % mod : 1)) % mod;
                else
                    dp[i] = dp[i - 1] % mod;
            }
        }

        return dp[n - 1] % mod;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(countWays(str));
    }

}