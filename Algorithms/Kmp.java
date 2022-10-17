public class Kmp {
    // String matching algo whose time complexity aprox = O(N)
    private static void calculateLps(String pat, int[] lps, int n) {
        lps[0] = 0;
        int i = 1, len = 0;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i] = len + 1;
                len++;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else
                    lps[i] = 0;
                i++;
            }
        }
    }

    private static void find(String s, String pat) {
        int i = 0, j = 0, m = s.length(), n = pat.length();

        int lps[] = new int[n];
        calculateLps(pat, lps, n);

        while (i < m) {
            if (s.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
            if (j == n) {
                System.out.println(i - n + " " + i);
                j = lps[j - 1];
            }
        }
    }

    public static void main(String[] args) {
        String s = "onionionspra";
        String pat = "onions";

        find(s, pat);
    }
}
