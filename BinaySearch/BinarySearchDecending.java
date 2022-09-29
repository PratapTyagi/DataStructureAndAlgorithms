public class BinarySearchDecending {
    static private int find(int[] arr, int val) {
        int n = arr.length;
        if (n == 0)
            return -1;
        if (n == 1)
            return arr[0] == val ? 0 : -1;

        int low = 0, high = n - 1;
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

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1, 0 };
        System.out.println(find(arr, 0));
    }
}
