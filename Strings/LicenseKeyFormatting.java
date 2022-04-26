public class LicenseKeyFormatting {
    static String ReFormatString(String s, int k) {
        int n = s.length(), count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (count == k && c != '-') {
                count = 0;
                sb.append('-');
            }
            if (c != '-') {
                sb.append(c);
                count++;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        int K = 4;
        System.out.println(ReFormatString(S, K));
    }
}
