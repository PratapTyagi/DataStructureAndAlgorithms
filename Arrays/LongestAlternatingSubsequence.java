public class LongestAlternatingSubsequence {
    static int AlternatingaMaxLength(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 1;

        int increasing = 1, decreasing = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])
                decreasing = increasing + 1;
            else if (arr[i] > arr[i - 1])
                increasing = decreasing + 1;
        }
        return Math.max(increasing, decreasing);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
        System.out.println(AlternatingaMaxLength(nums));
    }
}
