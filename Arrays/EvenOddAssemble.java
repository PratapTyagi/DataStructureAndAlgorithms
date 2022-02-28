package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class EvenOddAssemble {

    static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void assemble(Integer[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - count; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[arr.length - count - 1] % 2 == 0) {
                    for (int j = arr.length - count - 1; j > i; j--) {
                        if (arr[j] % 2 != 0)
                            break;
                        count++;
                    }
                }
                swap(arr, i, arr.length - count - 1);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 4, 16, 15, 1, 8, 10 };

        assemble(arr);

        int evenIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenIndex = i;
                break;
            }
        }
        Arrays.sort(arr, 0, evenIndex);
        Arrays.sort(arr, evenIndex, arr.length, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
