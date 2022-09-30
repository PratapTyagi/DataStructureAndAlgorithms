public class FindFloorValueInSortedArray {
    private static int find(int[] arr, int n, int val) {
        if (n == 0)
            return Integer.MIN_VALUE;
        if (n == 1)
            return Integer.MIN_VALUE;

        int low = 0, high = n - 1;
        int res = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == val)
                high = mid - 1;
            else if (arr[mid] > val)
                high = mid - 1;
            else {
                low = mid + 1;
                res = Math.max(res, arr[mid]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 8 };
        System.out.println(find(arr, arr.length, 1));
    }
}
