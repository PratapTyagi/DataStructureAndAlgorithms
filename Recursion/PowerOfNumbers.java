public class PowerOfNumbers {
    static long power(int n, int r) {
        if (r == 1)
            return n;
        if (r == 0)
            return 1;

        int mod = 1000000007;
        long pow = power(n, r / 2) % mod;
        pow = (pow * pow) % mod;

        if (r % 2 == 0)
            return pow;
        else
            return (n * pow) % mod;
    }

    public static void main(String[] args) {
        int n = 12;
        int r = 21;
        System.out.println(power(n, r));
    }
}
