public class QuickSort {
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
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
