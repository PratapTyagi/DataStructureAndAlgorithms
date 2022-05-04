public class LongestPrefixSuffix {
    static int lps(String s) {
        int n = s.length();
        int[] arr = new int[n];
        arr[0] = 0;
        int i = 1, len = 0;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                arr[i] = len + 1;
                len++;
                i++;
            } else {
                if (len != 0)
                    len = arr[len - 1];
                else {
                    arr[i] = 0;
                    i++;
                }
            }
        }

        return arr[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(lps("aaaa"));
    }
}
