import java.util.ArrayList;

public class MinimumSubsetSumDifference {
    static int subsetSum(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= sum / 2; i++)
            if (dp[dp.length - 1][i])
                temp.add(i);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.size(); i++)
            min = Math.min(sum - 2 * temp.get(i), min);

        return (min);
    }

    public static void main(String[] args) {
        int set[] = new int[] { 1, 6, 31, 5 };
        int ans = subsetSum(set, set.length);
        System.out.println(ans);
    }
}
