import java.util.HashMap;

public class LongestConsecutiveSubsequence {
    static int findLongestConseqSubseq(int arr[], int N) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i : arr)
            map.put(i, true);
        for (int i : arr)
            if (map.containsKey(i - 1))
                map.put(i, false);

        int ans = 0;
        for (int i : arr) {
            if (map.get(i)) {
                int len = 1;
                while (map.containsKey(i + len))
                    len++;
                ans = Math.max(len, ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int N = 7;
        int a[] = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println(findLongestConseqSubseq(a, N));
    }
}
