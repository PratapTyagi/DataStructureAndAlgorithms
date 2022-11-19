public class CountTotalSetBits {
    private static int highestPowerOfTwo(int n) {
        int ans = 0;

        while ((1 << ans) <= n) {
            ans++;
        }

        return ans - 1;
    }

    static int countSetBits(int n) {
        if (n == 0)
            return 0;

        int x = highestPowerOfTwo(n);
        int setBitsTillOneLessThanX = (1 << (x - 1)) * x;
        int msbForRest = n - (1 << x) + 1;
        int rest = n - (1 << x);

        int ans = setBitsTillOneLessThanX + msbForRest + countSetBits(rest);
        return ans;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(countSetBits(n));
    }
}
