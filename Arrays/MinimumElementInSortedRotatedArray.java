public class MinimumElementInSortedRotatedArray {
    static int findMin(int arr[], int n) {
        int start = 0, end = n - 1;
        if (arr[start] <= arr[end])
            return arr[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            else if (arr[mid] < arr[mid - 1])
                return arr[mid];
            else if (arr[start] <= arr[mid])
                start = mid + 1;
            else if (arr[mid] <= arr[end])
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 5, 7 };

        System.out.println(findMin(arr, arr.length));
    }
}
