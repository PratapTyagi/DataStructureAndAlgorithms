public class LongestIncreasingSubsequence {
    static int longestSubsequence(int size, int arr[]) {
        int[] dp = new int[size];

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j])
                    max = Math.max(max, dp[j]);

            dp[i] = max + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println(longestSubsequence(arr.length, arr));
    }
}
