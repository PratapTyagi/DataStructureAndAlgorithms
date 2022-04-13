import java.util.Arrays;

public class MinimizeTowersHeights {
    static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[n - 1] - k, arr[i - 1] + k);

            if (min < 0)
                continue;
            ans = Math.min(ans, max - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 10 };
        System.out.println(getMinDiff(arr, arr.length, 2));
    }
}
