import java.util.HashMap;

public class InterleavedStrings {
    static boolean solve(String a, String b, String c, int ptr1, int ptr2, int ptr3, HashMap<String, Boolean> map) {
        if (ptr3 == c.length())
            return (ptr2 == b.length() && ptr1 == a.length()) ? true : false;

        String key = ptr1 + "," + ptr2 + "," + ptr3;
        if (map.containsKey(key))
            return map.get(key);

        if (ptr1 == a.length()) {
            boolean ans = b.charAt(ptr2) == c.charAt(ptr3) ? solve(a, b, c, ptr1, ptr2 + 1, ptr3 + 1, map) : false;
            map.put(key, ans);
            return ans;
        }
        if (ptr2 == b.length()) {
            boolean ans = a.charAt(ptr1) == c.charAt(ptr3) ? solve(a, b, c, ptr1 + 1, ptr2, ptr3 + 1, map) : false;
            map.put(key, ans);
            return ans;
        }

        boolean one = false, two = false;
        if (a.charAt(ptr1) == c.charAt(ptr3))
            one = solve(a, b, c, ptr1 + 1, ptr2, ptr3 + 1, map);
        if (b.charAt(ptr2) == c.charAt(ptr3))
            two = solve(a, b, c, ptr1, ptr2 + 1, ptr3 + 1, map);

        map.put(key, one || two);
        return one || two;
    }

    static boolean isInterLeave(String a, String b, String c) {
        int len1 = a.length();
        int len2 = b.length();
        int len3 = c.length();
        if (len3 != (len1 + len2))
            return false;

        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return solve(a, b, c, 0, 0, 0, map);
    }

    public static void main(String[] args) {
        String A = "YX", B = "X", C = "XXY";
        System.out.println(isInterLeave(A, B, C));
    }
}
