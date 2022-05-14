public class SortArray {
    static void sort(int[] arr, int n) {
        if (n > 1) {
            int maxIndex = getMaxIndex(arr, n);
            swap(arr, n - 1, maxIndex);
            sort(arr, n - 1);
        }
    }

    static int getMaxIndex(int[] arr, int n) {
        int max = arr[0], maxIndex = 0;

        for (int i = 0; i < n; i++)
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }

        return maxIndex;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 3, 0, 1 };
        sort(arr, arr.length);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
