public class QuickSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start, j = start;

        while (i <= end) {
            if (arr[i] <= pivot)
                swap(arr, i++, j++);
            else
                i++;
        }

        return j - 1;
    }

    static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            sort(arr, start, p - 1);
            sort(arr, p + 1, end);
        }
    }

    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 3, 2, 1, 0 };
        sort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
