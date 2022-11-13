public class KernighanAlgo {
    // count no of set bits in a no
    // example: n = 11(1011) 3 set bits

    // rmsb(right most set bit) -> n and 2's complement of n gives rmsb
    public static void main(String[] args) {
        int n = 11;

        int count = 0;
        while (n != 0) {
            int rsb = n & -n; // rmsb
            n = n - rsb;
            count++;
        }

        System.out.println(count);
    }
}
