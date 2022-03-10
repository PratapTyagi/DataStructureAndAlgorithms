public class EggDropingProblem {
    static int ways(int e, int f, int[][] dp) {
        if (f == 0 || f == 1)
            return f;
        if (e == 1)
            return f;

        if (dp[e][f] != -1)
            return dp[e][f];

        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int temp = Math.max(ways(e, f - k, dp), ways(e - 1, k - 1, dp)) + 1;
            ans = Math.min(temp, ans);
        }
        return dp[e][f] = ans;
    }

    public static void main(String[] args) {
        int e = 3, f = 8;
        int[][] dp = new int[e + 1][f + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        System.out.println(ways(e, f, dp));
    }
}