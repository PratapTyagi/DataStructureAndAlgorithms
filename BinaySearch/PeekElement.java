public class PeekElement {
    private static boolean isPeek(int[] arr, int mid, int n) {
        return (mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]);
    }

    private static int peakElement(int[] arr, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPeek(arr, mid, n))
                return mid;
            else if (mid != 0 && arr[mid] < arr[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 14, 14, 10, 4, 13, 8, 17 };
        System.out.println(peakElement(arr, arr.length));
    }
}
