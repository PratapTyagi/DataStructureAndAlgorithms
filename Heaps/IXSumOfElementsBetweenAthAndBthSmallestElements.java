import java.util.Collections;
import java.util.PriorityQueue;

public class IXSumOfElementsBetweenAthAndBthSmallestElements {
    static long kthSmallest(long arr[], long k) {
        PriorityQueue<Long> q = new PriorityQueue<>(Collections.reverseOrder());

        for (long i : arr) {
            q.add(i);

            if (q.size() > k)
                q.remove();
        }

        return q.remove();
    }

    public static long sumBetweenTwoKth(long arr[], long N, long K1, long K2) {
        long a = kthSmallest(arr, K1);
        long b = kthSmallest(arr, K2);

        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        long sum = 0;
        for (int i = 0; i < N; i++)
            if (arr[i] > a && arr[i] < b)
                sum += arr[i];

        return sum;
    }

    public static void main(String[] args) {
        long A[] = { 20, 8, 22, 4, 12, 10, 14 },
                K1 = 3, K2 = 6;
        System.out.println(sumBetweenTwoKth(A, A.length, K1, K2));
    }
}
