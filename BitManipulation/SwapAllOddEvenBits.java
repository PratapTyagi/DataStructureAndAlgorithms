public class SwapAllOddEvenBits {
    static int swapBits(int n) {
        // Hexadecimal 32 bit numbers
        int om = 0x55555555;
        int em = 0xAAAAAAAA;

        int odds = (n & om);
        int evens = (n & em);

        odds <<= 1;
        evens >>= 1;

        n = odds | evens;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(swapBits(23));
    }
}
