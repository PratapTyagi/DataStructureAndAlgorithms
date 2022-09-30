public class MinDiffElementInSortedArray {
    private static int find(int[] arr, int n, int val) {
        if (n == 0)
            return -1;
        if (n == 1)
            return arr[0];

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == val)
                return val;
            else if (arr[mid] > val)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (low >= n)
            return arr[n - 1];
        else if (high < 0)
            return arr[0];

        int floorValue = arr[high];
        int ceilValue = arr[low];

        int floorRes = Math.abs(floorValue - val);
        int ceilRes = Math.abs(ceilValue - val);
        return Math.min(floorRes, ceilRes) == floorRes ? floorValue : ceilValue;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 6, 10 };
        System.out.println(find(arr, arr.length, 1));
    }
}
