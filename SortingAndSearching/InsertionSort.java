public class InsertionSort {
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

        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 5, 8, 3, 1, 2 };

        sort(arr);
        printArray(arr);
    }
}
