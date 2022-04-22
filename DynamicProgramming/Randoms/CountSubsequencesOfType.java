public class CountSubsequencesOfType {
    // Count subsequences of type a^i, b^j, c^k
    // find subseq ending with a ab abc respectively
    // a = 2*a + 1
    // ab = 2*ab + a
    // abc = 2*abc + ab

    static int fun(String s) {
        int a = 0;
        int ab = 0;
        int abc = 0;
        int n = s.length();
        int mod = 1000000007;

        s = s.toLowerCase();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a')
                a = ((2 * a) % mod + 1) % mod;
            else if (s.charAt(i) == 'b')
                ab = ((2 * ab) % mod + a) % mod;
            else if (s.charAt(i) == 'c')
                abc = ((2 * abc) % mod + ab) % mod;
        }

        return abc % mod;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(fun(s));
    }
}
