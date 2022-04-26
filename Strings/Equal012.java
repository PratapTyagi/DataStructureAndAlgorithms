import java.util.HashMap;

public class Equal012 {
    static long getSubstringWithEqual012(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0,0", 1);
        int n = s.length();
        int[] c = { 0, 0, 0 };
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0'; // Get number from char
            c[num]++;
            String key = (c[0] - c[1]) + "," + (c[1] - c[2]);
            ans += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "102";
        System.out.println(getSubstringWithEqual012(s));
    }
}
