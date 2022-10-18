import java.util.Collections;
import java.util.PriorityQueue;

public class IKthSmallestNo {
    static int solve(int[] arr, int n, int k) {
        if (k >= n)
            return Integer.MAX_VALUE;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);

            if (q.size() == k + 1)
                q.remove();
        }

        if (q.size() == k + 1)
            q.remove();

        return q.remove();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        int ans = solve(arr, arr.length, 3);
        System.out.println(ans);
    }
}
