public class SearchInRowAndColwiseSortedMatrix {

    private static boolean inBoundary(int[][] arr, int m, int n, int low, int high) {
        return low >= 0 && low < m && high >= 0 && high < n;
    }

    private static int[] find(int[][] arr, int val) {
        int m = arr.length, n = arr[0].length;
        if (m == 0)
            return new int[] { -1, -1 };

        int low = 0, high = n - 1;

        while (inBoundary(arr, m, n, low, high)) {
            int mid = arr[low][high];
            if (mid == val)
                return new int[] { low, high };
            else if (mid > val)
                high--;
            else
                low++;
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 10, 20, 80, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };
        int[] ans = find(arr, 27);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
