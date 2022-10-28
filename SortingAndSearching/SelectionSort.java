public class SelectionSort {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIdx] > arr[j])
                    minIdx = j;
            }

            swap(arr, i, minIdx);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 5, 8, 3, 1, 2 };

        sort(arr);
        printArray(arr);
    }
}
