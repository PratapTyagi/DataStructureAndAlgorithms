package Arrays;

public class SortArrayOf0s1s2s {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, mid++, low++);
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr, mid, high--);
                    break;

                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 1, 0, 2, 0, 1 };
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
