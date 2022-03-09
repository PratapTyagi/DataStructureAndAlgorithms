import java.util.HashMap;

public class ScrambledString {
    static HashMap<String, Boolean> map = new HashMap<>();

    static boolean isScrambled(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        if (map.containsKey(s1 + "" + s2))
            return map.get(s1 + "" + s2);

        if (s1.equals(s2))
            return true;

        if (s1.length() <= 1)
            return false;

        boolean flag = false;
        int n = s1.length();
        for (int k = 1; k < n; k++) {
            boolean condition1 = isScrambled(s1.substring(0, k), s2.substring(n - k, n)) == true
                    && isScrambled(s1.substring(k, n), s2.substring(0, n - k)) == true;
            boolean condition2 = isScrambled(s1.substring(0, k), s2.substring(0, k)) == true
                    && isScrambled(s1.substring(k), s2.substring(k)) == true;

            if (condition1 || condition2) {
                flag = true;
                break;
            }
        }

        map.put(s1 + "" + s2, flag);
        return flag;
    }

    public static void main(String[] args) {
        String s1 = "knxhpkpcogzwrwdyfksw", s2 = "fpsprgdywowkckhzxnkw";
        System.out.println(isScrambled(s1, s2));
    }
}
