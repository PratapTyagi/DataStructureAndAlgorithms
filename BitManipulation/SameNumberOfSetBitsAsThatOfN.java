public class SameNumberOfSetBitsAsThatOfN {
    static long ncr(long n, long r) {
        if (r > n)
            return 0L;

        long res = 1L;
        for (long i = 0L; i < r; i++) {
            res = res * (n - i);
            res = res / i + 1;
        }

        return res;
    }

    static long solution(long n, long k, long i) {
        if (i == 0)
            return 0L;

        long res = 0L;
        long mask = 1L << i;
        if ((n & mask) == 0) {
            res = solution(n, k, i - 1);
        } else {
            long res1 = solution(n, k - 1, i - 1);
            long res0 = ncr(i, k);

            res = res0 + res1;
        }

        return res;
    }

    static long totalSetBits(long n) {
        long res = 0;

        while (n > 0) {
            long rmsb = n & -n;
            n -= rmsb;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        long n = 12;
        long k = totalSetBits(n);

        System.out.println(solution(n, k, 63));
    }
}
