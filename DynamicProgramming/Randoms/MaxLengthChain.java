import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthChain {
    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    static class CompareByFirst implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.y - b.y;
        }
    }

    static int maxChainLength(Pair arr[], int n) {
        Arrays.sort(arr, new CompareByFirst());

        // LIS
        int max = 1;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j].y < arr[i].x)
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
            }
            max = Math.max(lis[i], max);
        }

        /*
         * int count = 1;
         * int end = arr[0].y;
         * 
         * for(int i=1; i<n; i++) {
         * if(arr[i].x > end) {
         * count ++;
         * end = arr[i].y;
         * }
         * }
         * 
         * return count;
         */

        return max;
    }

    public static void main(String[] args) {
        Pair[] arr = new Pair[5];
        int[][] pair = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };

        for (int i = 0; i < arr.length; i++)
            arr[i] = new Pair(pair[i][0], pair[i][1]);

        System.out.println(maxChainLength(arr, arr.length));
    }
}
