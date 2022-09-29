public class NumberOfTimesArrayIsRotated {
    private static int find(int[] arr, int n) {
        if (n == 0 || n == 1)
            return 0;
        int low = 0, high = n - 1;

        if (arr[low] <= arr[high])
            return 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid + 1])
                return mid + 1;
            else if (arr[mid] < arr[mid - 1])
                return mid;
            else if (arr[low] <= arr[mid])
                low = mid + 1;
            else if (arr[high] >= arr[mid])
                high = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 1 };
        System.out.println(find(arr, arr.length));
    }
}
