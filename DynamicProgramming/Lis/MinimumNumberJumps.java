public class MinimumNumberJumps {
    static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            if (steps == 0)
                dp[i] = Integer.MAX_VALUE;

            else if (steps >= n - i - 1)
                dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j < n && j <= arr[i] + i; j++)
                    if (dp[j] < min)
                        min = dp[j];

                if (min != Integer.MAX_VALUE)
                    dp[i] = min + 1;
                else
                    dp[i] = min;
            }
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println(minJumps(arr));
    }
}
