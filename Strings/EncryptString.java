public class EncryptString {
    static String encryptString(String s) {
        String res = "";
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
                continue;
            } else {
                res += count > 9 ? s.charAt(i - 1) + "" + Integer.toHexString(count) + ""
                        : s.charAt(i - 1) + "" + count + "";
                count = 1;
            }
        }
        res += count > 9 ? s.charAt(s.length() - 1) + "" + Integer.toHexString(count) + ""
                : s.charAt(s.length() - 1) + "" + count + "";

        // System.out.println(s.charAt(s.length() - 1) + "" + s.charAt(s.length() - 2));
        String ans = "";
        count = 0;
        for (int i = res.length() - 1; i >= 0; i--) {
            if (Character.isDigit(res.charAt(i))) {
                count++;
            } else {
                if (count != 0) {
                    ans += res.substring(i + 1, i + count + 1);
                    count = 0;
                }
                ans += res.charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaa";
        System.out.println(encryptString(s));
    }
}
