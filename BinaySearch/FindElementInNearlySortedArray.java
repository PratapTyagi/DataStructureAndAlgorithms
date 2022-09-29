public class FindElementInNearlySortedArray {
    private static int find(int[] arr, int val, int low, int high) {
        int n = high - low + 1;
        if (n == 0)
            return -1;
        if (n == 1)
            return arr[low] == val ? 0 : -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == val)
                return mid;
            else if (arr[mid + 1] == val)
                return mid + 1;
            else if (arr[mid - 1] == val)
                return mid - 1;
            else if (arr[mid] > val)
                high = mid - 2;
            else
                low = mid + 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 11, 10, 30, 20, 40 };
        System.out.println(find(arr, 20, 0, arr.length - 1));
    }
}
