public class BubbleSort {

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
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 5, 8, 3, 1, 2 };

        sort(arr);
        printArray(arr);
    }
}
