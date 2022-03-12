public class CountNumberOfHops {
    static long count(int limit, long[] dp) {
        if (limit < 0)
            return 0;
        if (limit == 0)
            return 1;

        if (dp[limit] != -1)
            return dp[limit];

        return dp[limit] = (count(limit - 1, dp) + count(limit - 2, dp) + count(limit - 3, dp)) % 1000000007;
    }

    static long countWays(int limit) {
        long dp[] = new long[limit + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;
        return count(limit, dp);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countWays(n));
    }
}
