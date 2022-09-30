public class FindPositionInInfiniteSortedArray {
    private static int find(int[] arr, int n, int val) {
        int low = 0, high = 1;

        while (high < n && arr[high] <= val) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == val)
                return mid;
            else if (arr[mid] < val)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
        System.out.println(find(arr, arr.length, 24));
    }
}
