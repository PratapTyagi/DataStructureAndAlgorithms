public class FindElementInRotatedSortedArray {
    private static int minimumIndex(int[] arr, int n) {
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
            else if (arr[mid] > val)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 2, 3 };
        int minimumIndex = minimumIndex(arr, arr.length);
        int firstSubsetAns = find(arr, 10, 0, minimumIndex - 1);
        int secondSubsetAns = find(arr, 10, minimumIndex, arr.length - 1);

        if (firstSubsetAns != -1) {
            System.out.println(firstSubsetAns);
            return;
        } else {
            System.out.println(secondSubsetAns);
            return;
        }
    }
}
