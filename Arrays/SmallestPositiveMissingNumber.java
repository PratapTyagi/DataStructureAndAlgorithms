public class SmallestPositiveMissingNumber {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void arrange(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1])
                swap(arr, i, arr[i] - 1);
    }

    static int missingNumber(int arr[], int size) {
        arrange(arr, size);
        for (int i = 0; i < size; i++)
            if (i + 1 != arr[i])
                return i + 1;

        return size + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 0, -10, 1, 3, -20 };
        System.out.println(missingNumber(arr, arr.length));
    }
}
