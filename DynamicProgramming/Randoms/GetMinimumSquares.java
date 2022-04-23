import java.util.Arrays;

public class GetMinimumSquares {
    static int solve(int n, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int ans = Integer.MAX_VALUE;
        String p = Math.sqrt(n) + "";
        int sqrt = Integer.parseInt(p.split("\\.")[0]);
        for (int i = 1; i <= sqrt; i++) {
            int temp = 1 + solve(n - (i * i), dp);
            ans = Math.min(ans, temp);
        }
        return dp[n] = ans;
    }

    static int MinSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    public static void main(String[] args) {
        System.out.println(MinSquares(6));
    }
}
