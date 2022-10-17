import java.util.ArrayList;

public class RollingHash {
    // String pattern match in O(n)

    private static void solve(String s, String t) {
        int n = s.length();
        int m = t.length();

        long p = 31;
        long pow = p;
        long mod = 1000000007;
        long dhv = s.charAt(0) - 'a' + 1; // desired hash value

        // hash value for target string
        for (int i = 1; i < m; i++) {
            dhv = (dhv + (s.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (pow * p) % mod;
        }

        // Rabin karp
        long[] dp = new long[n]; // prefix hash uptil current index
        long[] pa = new long[n]; // power array

        dp[0] = s.charAt(0) - 'a' + 1;
        pa[0] = 1;
        pow = p;
        for (int i = 1; i < n; i++) {
            dp[i] = (dp[i - 1] + (s.charAt(i) - 'a' + 1) * pow) % mod;
            pa[i] = pow;
            pow = (pow * p) % mod;
        }

        int start = 0, end = m - 1;
        ArrayList<Integer> al = new ArrayList<>();

        while (end < n) {
            long wind = dp[end];
            if (start > 0)
                wind = (wind - dp[start - 1] + mod) % mod;
            if (wind == (dhv * pa[start]) % mod)
                al.add(start + 1);
            start++;
            end++;
        }

        System.out.println(al.size());
        for (Integer i : al)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        String str = "abababc";
        String pattern = "ab";

        solve(str, pattern);
    }
}
