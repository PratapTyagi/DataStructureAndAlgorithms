package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int sum = 0, high = 0, low = 0;
        while (high < n) {
            sum += arr[high];
            if (sum == s)
                return new ArrayList<>(Arrays.asList(low + 1, high + 1));
            if (sum > s) {
                while (low <= high && sum > s)
                    sum -= arr[low++];

                if (sum == s)
                    return new ArrayList<>(Arrays.asList(low + 1, high + 1));
            }
            high++;
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;
        int S = 20;
        ArrayList<Integer> al = subarraySum(arr, n, S);
        if (al.size() == 2)
            System.out.println(al.get(0) + " " + al.get(1));
        else
            System.out.println(al.get(0));

    }
}
