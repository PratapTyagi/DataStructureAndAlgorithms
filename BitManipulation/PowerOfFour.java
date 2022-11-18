public class PowerOfFour {
    // 0xAAAAAAAA -> 0b10101010101010101010101010101010
    static int isPowerOfFour(long n) {
        if (n < 1)
            return 0;
        return ((n & (n - 1)) == 0) && ((n & 0xAAAAAAAA) == 0) ? 1 : 0;
    }

    public static void main(String[] args) {
        long n = 64;
        System.out.println(isPowerOfFour(n) == 1);
    }
}
