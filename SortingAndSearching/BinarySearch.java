public class BinarySearch {
    static int search(int[] arr, int x, int start, int end) {
        while (end >= start) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                end = mid - 1;
            else
                start = mid + 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 4, 10, 40 };

        System.out.println(search(arr, 40, 0, arr.length - 1));
    }
}
