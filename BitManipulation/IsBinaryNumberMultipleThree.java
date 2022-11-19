public class IsBinaryNumberMultipleThree {
    /*
     * There is a pattern in the binary representation of a number that can be used
     * to find if a number is a multiple of 3. If the difference between the count
     * of odd set bits (Bits set at odd positions) and even set bits is a multiple
     * of 3
     */
    static int isDivisible(String s) {
        int n = s.length();
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < n; i++) {
            int bit = s.charAt(i) - '0';

            if (i % 2 == 0)
                evenSum += bit;
            else
                oddSum += bit;
        }

        int delta = evenSum - oddSum;

        return delta % 3 == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "100100000111111101010010010011010101110110";
        System.out.println(isDivisible(s));
    }
}
