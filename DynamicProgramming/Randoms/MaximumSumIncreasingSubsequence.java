public class MaximumSumIncreasingSubsequence {
    static int maxSumIS(int arr[], int n) {
        int lis[] = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j])
                    currentMax = Math.max(currentMax, lis[j]);

            lis[i] = currentMax + arr[i];
            max = Math.max(max, lis[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int N = 5, arr[] = { 1, 101, 2, 3, 100 };

        System.out.println(maxSumIS(arr, N));
    }
}
