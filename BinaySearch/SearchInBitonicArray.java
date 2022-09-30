public class SearchInBitonicArray {
    private static int findEle(int[] arr, int val, int low, int high) {
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

    private static int findEleDec(int[] arr, int val, int low, int high) {
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
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    private static boolean isPeek(int[] arr, int mid, int n) {
        return (mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]);
    }

    private static int findMax(int[] arr, int n) {
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
        int[] arr = { 1, 20, 50, 40, 10 };
        int n = arr.length;
        int val = 5;
        int maxIndex = findMax(arr, n);
        int firstHalfRes = findEle(arr, val, 0, maxIndex - 1);
        int secondHalfRes = findEleDec(arr, val, maxIndex, n - 1);
        if (firstHalfRes != -1) {
            System.out.println(firstHalfRes);
            return;
        }
        System.out.println(secondHalfRes);
    }
}
