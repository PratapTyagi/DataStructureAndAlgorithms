public class MinimumElementInSortedRotatedArray {
    static int findMin(int arr[], int n) {
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == 0)
                return Math.min(arr[end], arr[start]);
            else if (mid == n - 1)
                return arr[mid];

            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            if (arr[mid] < arr[next] && arr[mid] < arr[prev])
                return arr[mid];
            else if (arr[mid] > arr[end])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 5, 7 };

        System.out.println(findMin(arr, arr.length));
    }
}
