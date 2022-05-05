public class LengthOfLongestSubstring {
    static int longestUniqueSubsttr(String s) {
        int[] temp = new int[26];
        int i = 1, j = 0;
        int n = s.length();
        int ans = 1;
        temp[s.charAt(0) - 'a']++;

        // Sliding window
        while (i < n) {
            int num = s.charAt(i) - 'a';
            if (temp[num] > 0) {
                temp[s.charAt(j) - 'a']--;
                j++;
            } else {
                temp[num]++;
                i++;
            }
            ans = Math.max(i - j, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubsttr(s));
    }
}
