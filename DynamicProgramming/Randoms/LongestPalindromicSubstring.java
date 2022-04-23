public class LongestPalindromicSubstring {
    static String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 1;
        int start = 0, end = 0;
        int[][] lps = new int[n][n];

        // Initialize single element as palindrome
        for (int i = 0; i < lps.length; i++)
            lps[i][i] = 1;

        // If two elements are equal then they are palindrome
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                lps[i - 1][i] = 1;
                if (maxLength < 2) {
                    start = i - 1;
                    end = i;
                    maxLength = 2;
                }
            }
        }

        // Fill rest matrix using condition
        for (int i = 2; i < n; i++) {
            for (int j = 0, k = i; j < n - i && k < n; j++, k++) {
                if (s.charAt(j) == s.charAt(k) && lps[j + 1][k - 1] == 1) {
                    lps[j][k] = 1;
                    if (maxLength < k - j + 1) {
                        start = j;
                        end = k;
                        maxLength = k - j + 1;
                    }
                }
            }
        }

        // Result string with start and end values
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String S = "aaaabbaa";
        System.out.println(longestPalindrome(S));
    }
}
