public class BitDifference {
    private final static long mod = 1000000007;

    static int countBits(int N, long a[]) {
        long res = 0;

        for (int i = 0; i < 32; i++) {
            long countSetBits = 0;
            long countUnsetBits = 0;

            for (int j = 0; j < N; j++) {
                if ((a[j] & (1 << i)) == 0)
                    countUnsetBits++;
                else
                    countSetBits++;
            }

            long pairs = (countSetBits * countUnsetBits * 2) % mod;
            res += pairs;
        }

        return (int) (res % mod);
    }

    public static void main(String[] args) {
        long[] arr = { 1, 3, 5 };

        System.out.println(countBits(arr.length, arr));
    }
}
