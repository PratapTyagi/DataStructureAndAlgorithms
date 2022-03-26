public class CatalanNumber {
    static int find(int n) {
        long mod = 1000000007;
        long dp[] = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long sum = 0;

            for (int j = 0, k = i - 1; j < i && k >= 0; j++, k--)
                sum = (sum + (dp[j] * dp[k]) % mod) % mod;

            dp[i] = sum % mod;
        }

        return (int) (dp[n] % mod);
    }

    public static void main(String[] args) {
        int position = 5;
        System.out.println(find(position));
    }
}
