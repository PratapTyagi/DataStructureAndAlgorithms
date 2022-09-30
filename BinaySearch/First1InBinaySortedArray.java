public class First1InBinaySortedArray {
    private static int find(int[] arr, int n) {
        int low = 0, high = 1;
        while (high < n && arr[high] != 1) {
            low = high;
            high *= 2;
        }

        int pos = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                pos = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return pos;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        System.out.println(find(arr, arr.length));
    }
}
