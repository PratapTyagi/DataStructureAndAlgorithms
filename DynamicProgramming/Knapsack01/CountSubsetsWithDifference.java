public class CountSubsetsWithDifference {
    static int count(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0)
            return 1;
        if (n <= 0)
            return 0;

        if (dp[n - 1][sum] != -1)
            return dp[n - 1][sum];

        if (arr[n - 1] <= sum)
            return dp[n - 1][sum] = count(arr, sum, n - 1, dp) + count(arr, sum - arr[n - 1], n - 1, dp) % 1000000007;
        else
            return dp[n - 1][sum] = count(arr, sum, n - 1, dp) % 1000000007;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 2, 3 };
        int difference = 1;

        int totalSum = 0;
        for (int i : arr)
            totalSum += i;

        int count = 0;
        int zeros = 1;
        for (int i = 0; i < arr.length - count; i++)
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - count];
                arr[arr.length - 1 - count] = temp;
                count++;
                zeros = (zeros * 2) % 1000000007;
            }

        int sum = (difference + totalSum) / 2;
        int dp[][] = new int[arr.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        System.out.println(count(arr, sum, arr.length - count, dp) * zeros);
    }
}